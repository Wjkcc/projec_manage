package com.echair.project_manage.service.impl;

import com.echair.project_manage.common.KeyUtils;
import com.echair.project_manage.common.MD2utils;
import com.echair.project_manage.common.TokenUtils;
import com.echair.project_manage.common.cache.MapCache;
import com.echair.project_manage.common.context.UserContext;
import com.echair.project_manage.common.pojo.dto.UserAddDTO;
import com.echair.project_manage.common.pojo.dto.UserDTO;
import com.echair.project_manage.common.pojo.vo.AssessVO;
import com.echair.project_manage.common.pojo.vo.UserVO;
import com.echair.project_manage.common.result.exception.BusinessException;
import com.echair.project_manage.dao.mapper.AssessMapper;
import com.echair.project_manage.dao.mapper.AssessRoleMapper;
import com.echair.project_manage.dao.mapper.RoleMapper;
import com.echair.project_manage.dao.mapper.UserMapper;
import com.echair.project_manage.dao.model.*;
import com.echair.project_manage.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/3 15:30
 **/
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Resource
    UserMapper userMapper;
    @Resource
    TokenUtils tokenUtils;
    @Resource
    RoleMapper roleMapper;
    @Resource
    AssessMapper assessMapper;
    @Resource
    AssessRoleMapper assessRoleMapper;
    @Override
    public Map<String, Object> login(UserDTO userDTO) {
        // 1.查询用户是否存在
        UserExample userExample = new UserExample();
        userExample.or().andUsernameEqualTo(userDTO.getUsername())
                .andPasswordEqualTo(userDTO.getPassword())
                .andIsDelEqualTo(0)
                .andStatusEqualTo(0);
        long l = userMapper.countByExample(userExample);
        // 2.查询用户具体信息
        if (l > 0) {
            /**
             * 起两条线程，一条查询用户基本信息，一条查询用户权限信息
             * CountDownLatch 控制 主线程和子线程之间的运行
             */
            Map<String,UserVO> map1 = new ConcurrentHashMap<>(1);
            Map<String,List<AssessVO>> map2 = new ConcurrentHashMap<>(1);
            Map<String,Object> r = new HashMap<>(2);
            CountDownLatch latch = new CountDownLatch(2);
            UserVO userVO = new UserVO();
            new Thread(()->{
                UserVO user = userMapper.getUser(userDTO.getUsername());
                map1.put("user",user == null ? new UserVO():user);
                latch.countDown();
            },"selUserData").start();

            new Thread(()->{
               List<AssessVO> assessVOS = userMapper.getAssess(userDTO.getUsername());
                map2.put("assess",assessVOS == null ? new ArrayList<>() :assessVOS);
                latch.countDown();
            },"selUserAssess").start();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            userVO = map1.get("user");
            userVO.setAssess(map2.get("assess"));
            // 生成token
            String token = tokenUtils.createToken(userVO.getUserid());
            // 3.信息保存到缓存
            MapCache.getInstance().setCache(userVO,24*60*60*1000);
            r.put("user",userVO);
            r.put("token",token);
            return r;
        }
        return null;
    }

    /**
     * 单线程登录
     * @param userDTO
     * @return
     */
    @Override
    public Map<String, Object> loginDefault(UserDTO userDTO) {
        UserVO user = userMapper.getUser(userDTO.getUsername());
        if (user != null) {
            List<AssessVO> assessVOS = userMapper.getAssess(userDTO.getUsername());
            List<AssessVO> assessVOS1 = setListAssess2(assessVOS);
            user.setAssess(assessVOS1);
            // 生成token
            String token = tokenUtils.createToken(user.getUserid());
            // 3.信息保存到缓存
            MapCache.getInstance().setCache(user,24*60*60*1000);
            Map<String,Object> r = new HashMap<>(2);
            r.put("user",user);
            r.put("token",token);
            return r;
        }
        return null;
    }

    /**
     * 通过callable接口来查询用户信息和权限，在task未获取到值的时候主线程阻塞
     * @param userDTO
     * @return
     */
    @Override
    public Map<String, Object> login1(UserDTO userDTO) {
        // 1.查询用户是否存在
        UserExample userExample = new UserExample();
        userExample.or().andUsernameEqualTo(userDTO.getUsername())
                .andPasswordEqualTo(userDTO.getPassword())
                .andIsDelEqualTo(0)
                .andStatusEqualTo(0);
        long l = userMapper.countByExample(userExample);
        // 2.查询用户具体信息
        if (l > 0) {
            /**
             * 起两条线程，一条查询用户基本信息，一条查询用户权限信息
             */
            UserVO userVO = null;
            List<AssessVO> assessVOS = null;
            FutureTask<UserVO> task1 = new FutureTask<>(() -> userMapper.getUser(userDTO.getUsername()));
            FutureTask<List<AssessVO>> task2 = new FutureTask<>(() -> userMapper.getAssess(userDTO.getUsername()));
            new Thread(task1,"selUserData").start();
            new Thread(task2,"selUserAssess").start();
            try {
               userVO = task1.get(3,TimeUnit.SECONDS);
               assessVOS = task2.get(3,TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            userVO.setAssess(assessVOS);
            String token = tokenUtils.createToken(userVO.getUserid());
            // 3.信息保存到缓存
            MapCache.getInstance().setCache(userVO,24*60*60*1000);
            Map<String,Object> r = new HashMap<>(2);
            r.put("user",userVO);
            r.put("token",token);
            return r;
        }
        return null;
    }

    /**
     * 添加用户
     * @param userDTO
     * @return
     */
    @Override
    public int addUser(UserAddDTO userDTO) {
        UserExample userExample = new UserExample();
        userExample.or().andUsernameEqualTo(userDTO.getUsername());
        if (userMapper.countByExample(userExample) > 0) {
            log.error("username is already exist");
            throw new BusinessException("用户名，已经存在");
        }
        String userid = KeyUtils.generateUserid();
        User user = new User();
        user.setCreateTime(new Date());
        user.setName(userDTO.getName());
        user.setRoleId(userDTO.getRoleId());
        user.setUserid(userid);
        user.setUsername(userDTO.getUsername());
        try {
            String password = MD2utils.MD2(userDTO.getPassword()+userid.substring(0,4));
            user.setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return userMapper.insertSelective(user);
    }

    /**
     * 修改用户信息,账号id不能不能修改
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        if (user.getPassword() != null) {
            try {
                String password = MD2utils.MD2(user.getPassword()+user.getUserid().substring(0,4));
                user.setPassword(password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        user.setUsername(null);
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }

    /**
     * 用户列表
     * @param user
     * @return
     */
    @Override
    public List<User> userList(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (user.getUsername() != null)
            criteria.andUsernameEqualTo(user.getUsername());
        if (user.getName() != null)
            criteria.andNameEqualTo(user.getName());
        criteria.andStatusEqualTo(0).andIsDelEqualTo(0);
        userExample.setOrderByClause("create_time desc");
        return userMapper.selectByExample(userExample);
    }

    /**
     * 删除用户
     * @param userid
     * @return
     */
    @Override
    public int delUser(String userid) {
        User user = new User();
        user.setUserid(userid);
        user.setIsDel(1);
        return  userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 角色列表
     * @return
     */
    @Override
    public List<Role> getRoles() {
        RoleExample roleExample = new RoleExample();
        roleExample.or().andIsDelEqualTo(0);
        return roleMapper.selectByExample(roleExample);
    }

    /**
     * 角色添加
     * @param role
     * @return
     */
    @Override
    public int addRole(Role role) {
        role.setRoleId(null);
        role.setCreateTime(new Date());
        role.setCreateTime(new Date());
        return roleMapper.insertSelective(role);
    }

    /**
     * 删除角色信息,删除关联角色信息
     * @param roleId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delRole(long roleId) {
        Role role = new Role();
        role.setRoleId(roleId);
        role.setIsDel(0);
        role.setUpdateTime(new Date());
        int i1 = roleMapper.updateByPrimaryKeySelective(role);
        if (i1 < 1) {
            log.error("role del fail");
            throw new BusinessException("角色删除失败");
        }
        AssessRoleExample assessRoleExample = new AssessRoleExample();
        assessRoleExample.or().andIsDelEqualTo(0).andRoleIdEqualTo(roleId);
        List<AssessRole> list = assessRoleMapper.selectByExample(assessRoleExample);
        list.forEach(e->{
            e.setIsDel(0);
            e.setUpdateTime(new Date());
            int i = assessRoleMapper.updateByPrimaryKey(e);
            if (i < 1) {
                log.error("assess_role del fail");
                throw new BusinessException("关联角色角色删除失败");
            }
        });
        return 1;
    }

    /**
     * 更新角色
     * @param role
     * @return
     */
    @Override
    public int updateRole(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 资源列表
     * @return
     */
    @Override
    public List<Assess> getAssess() {
        AssessExample assessExample = new AssessExample();
        assessExample.or().andIsDelEqualTo(0);
        return assessMapper.selectByExample(assessExample);
    }

    /**
     * 添加资源
     * @param assess
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addAssess(Assess assess) {
        assess.setAssessId(null);
        assess.setCreateTime(new Date());
        assess.setUpdateTime(new Date());
        int i = assessMapper.insertSelective(assess);
        if (i < 1) {
            log.error("assess add fail");
            throw new BusinessException("资源添加失败");
        }
        long id = assess.getAssessId();
        AssessRole assessRole = new AssessRole();
        assessRole.setUpdateTime(new Date());
        assessRole.setRoleId(assess.getRoleId());
        assessRole.setAssessId(id);
        assessRole.setCreateTime(new Date());
        int i1 = assessRoleMapper.insertSelective(assessRole);
        if (i1 < 1) {
            log.error("assess_role add fail");
            throw new BusinessException("角色资源关联表添加失败");
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delAssess(long assessId) {
        Assess assess = new Assess();
        assess.setAssessId(assessId);
        assess.setUpdateTime(new Date());
        assess.setIsDel(1);
        int i = assessMapper.updateByPrimaryKeySelective(assess);
        if (i < 1) {
            log.error("assess del fail");
            throw new BusinessException("资源删除失败");
        }
        AssessRoleExample assessRoleExample = new AssessRoleExample();
        assessRoleExample.or().andAssessIdEqualTo(assessId).andIsDelEqualTo(0);
        List<AssessRole> list = assessRoleMapper.selectByExample(assessRoleExample);
        list.forEach(e->{
            e.setUpdateTime(new Date());
            e.setIsDel(1);
            int i1 = assessRoleMapper.updateByPrimaryKeySelective(e);
            if (i1 <1) {
                log.error("assess_role del fail");
                throw new BusinessException("资源关联表删除失败");
            }
        });
        return 1;
    }

    /**
     * 更新资源
     * @param assess
     * @return
     */
    @Override
    public int updateAssess(Assess assess) {
        return assessMapper.updateByPrimaryKeySelective(assess);
    }

    public List<AssessVO> setListAssess(List<AssessVO> listAssess) {
        if (listAssess == null || listAssess.isEmpty()) {
            return new ArrayList<>();
        }
        List<AssessVO> rs = new ArrayList<>();
        List<AssessVO> res = new ArrayList<>();
        for (AssessVO a : listAssess) {
            if (a.getPid() == 0) {
                rs.add(a);
                continue;
            }
            res.add(a);
        }
        if(!res.isEmpty()) {
            for (AssessVO a : rs) {
                setChild(a,res);
            }
        }
        return rs;
    }
    private void setChild(AssessVO a, List<AssessVO> res) {
        List<AssessVO> add = new ArrayList<>();
        List<AssessVO> res1 = new ArrayList<>();
        for (AssessVO as : res) {
            if (a.getAssessId() == as.getPid()){
                add.add(as);
                continue;
            }
            res1.add(as);
        }
        if (add.isEmpty()) {
            return;
        }
        a.setChild(add);
        for (AssessVO as : add) {
            setChild(as,res1);
        }
    }
    /**
     * 资源权限排序，父级资源设置子级
     * @param listAssess
     */
    public List<AssessVO> setListAssess1(List<AssessVO> listAssess) {
        if (listAssess == null || listAssess.isEmpty()) {
            return new ArrayList<>();
        }
        List<AssessVO> rs = listAssess.parallelStream().filter(e -> e.getPid() == 0).collect(Collectors.toList());
        List<AssessVO> res = listAssess.parallelStream().filter(e -> e.getPid() != 0).collect(Collectors.toList());
        if (!res.isEmpty()) {
            rs.forEach(e -> {
                setChild1(e, res);
            });
        }
        return rs;
    }
    private void setChild1(AssessVO a, List<AssessVO> res) {
        List<AssessVO> add = res.parallelStream().filter(e -> a.getAssessId() == e.getPid()).collect(Collectors.toList());
        List<AssessVO> res1 = res.parallelStream().filter(e -> a.getAssessId() != e.getPid()).collect(Collectors.toList());
        if (add.isEmpty()) {
            return;
        }
        a.setChild(add);
        add.forEach(e -> {
            setChild1(e, res1);
        });
    }
    public List<AssessVO> setListAssess2(List<AssessVO> listAssess) {
            if (listAssess == null || listAssess.isEmpty()) {
                return new ArrayList<>();
            }
            List<AssessVO> rs = listAssess.parallelStream().filter(e -> e.getPid() == 0).collect(Collectors.toList());
            // 线程安全的list
            List<AssessVO> res1 = listAssess.parallelStream().filter(e -> e.getPid() != 0).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
//            List<AssessVO> res1 = listAssess.parallelStream().filter(e -> e.getPid() != 0).collect(Collectors.toList());
            if (!res1.isEmpty()) {
                rs.forEach(e -> {
                    setChild2(e, res1);
                });
            }
            return rs;
        }
    private void setChild2(AssessVO a, List<AssessVO> res) {
        if (res.isEmpty()) {
            return;
        }
        List<AssessVO> add = res.parallelStream().filter(e -> a.getAssessId() == e.getPid()).collect(Collectors.toList());
        if (add.isEmpty()) {
            return;
        }
        res.removeAll(add);
        a.setChild(add);
        add.forEach(e -> {
            setChild2(e, res);
        });
    }

}
