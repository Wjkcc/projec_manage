package com.echair.project_manage.service;

import com.echair.project_manage.common.pojo.dto.UserAddDTO;
import com.echair.project_manage.common.pojo.dto.UserDTO;
import com.echair.project_manage.common.pojo.vo.UserVO;
import com.echair.project_manage.dao.model.Assess;
import com.echair.project_manage.dao.model.Role;
import com.echair.project_manage.dao.model.User;

import java.util.List;
import java.util.Map;

/**
 * 登录接口
 */
public interface LoginService {
    /**
     * 登录 返回一个用户信息map
     * @param userDTO
     * @return
     */
    Map<String, Object> login(UserDTO userDTO);

    Map<String, Object> loginDefault(UserDTO userDTO);

    Map<String, Object> login1(UserDTO userDTO);

    int addUser(UserAddDTO userDTO);

    int update(User user);

    List<User> userList(User user);

    int delUser(String userid);

    List<Role> getRoles();

    int addRole(Role role);

    int delRole(long roleId);

    int updateRole(Role role);

    List<Assess> getAssess();

    int addAssess(Assess assess);

    int delAssess(long assessId);

    int updateAssess(Assess assess);

}
