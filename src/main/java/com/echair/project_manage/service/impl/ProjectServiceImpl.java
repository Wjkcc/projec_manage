package com.echair.project_manage.service.impl;

import com.echair.project_manage.common.pojo.dto.ProjectDTO;
import com.echair.project_manage.common.pojo.vo.*;
import com.echair.project_manage.common.result.exception.BusinessException;
import com.echair.project_manage.dao.mapper.*;
import com.echair.project_manage.dao.model.*;
import com.echair.project_manage.service.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.swing.plaf.nimbus.NimbusStyle;
import java.awt.font.NumericShaper;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/14 14:52
 **/
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectMapper projectMapper;
    @Resource
    ParticipationMapper participationMapper;
    @Resource
    FileMapper fileMapper;
    @Resource
    TaskMapper taskMapper;
    @Resource
    MessageMapper messageMapper;
    @Resource
    AlphaMapper alphaMapper;
    @Resource
    BetaMapper betaMapper;
    @Resource
    MasterMapper masterMapper;
    @Resource
    VersionMapper versionMapper;
    @Resource
    UserMapper userMapper;
    @Override
    public PageInfo<ProjectVO>  projectList(ProjectDTO projectDTO) {
        PageHelper.startPage(projectDTO.getPageNum(),projectDTO.getPageSize());
        List<ProjectVO> projectVOS = projectMapper.projectList(projectDTO);
        PageInfo<ProjectVO> r = new PageInfo<>(projectVOS);
        return r;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int projectDel(long projectId) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.or().andProjectIdEqualTo(projectId).andIsDelEqualTo(0);
        long l = projectMapper.countByExample(projectExample);
        if (l == 0) {
            log.error("项目不存在");
            throw new BusinessException("项目不存在");
        }
        // 删除项目，删除参与人员 ，删除任务集合，消息集合，文件集合
        Project p = new Project();
        p.setProjectId(projectId);
        p.setIsDel(1);
        int i = projectMapper.updateByPrimaryKeySelective(p);
        if (i < 1) {
            log.error("修改失败");
            throw new BusinessException("修改失败"+projectId);
        }
        // 参与人员
        ParticipationExample participationExample = new ParticipationExample();
        participationExample.or().andProjectIdEqualTo(projectId).andIsDelEqualTo(0);
        List<Participation> participations = participationMapper.selectByExample(participationExample);
        for (Participation pa : participations) {
            pa.setIsDel(1);
            int i1 = participationMapper.updateByPrimaryKeySelective(pa);
            if (i1 < 1) {
                log.error("删除失败");
                throw new BusinessException("删除失败" + pa.getId());
            }
        }
        // 任务
        TaskExample taskExample = new TaskExample();
        taskExample.or().andProjectIdEqualTo(projectId).andIsDelEqualTo(0);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        for (Task t : tasks) {
            t.setIsDel(1);
            int i1 = taskMapper.updateByPrimaryKeySelective(t);
            if (i1 < 1) {
                log.error("删除失败");
                throw new BusinessException("删除失败" + t.getTaskId());
            }
        }
        // 删除文件
        FileExample fileExample = new FileExample();
        fileExample.or().andProjectIdEqualTo(projectId).andIsDelEqualTo(0);
        List<File> files = fileMapper.selectByExample(fileExample);
        for(File f : files) {
            f.setIsDel(1);
            int i1 = fileMapper.updateByPrimaryKeySelective(f);
            if (i1 < 1) {
                log.error("删除失败");
                throw new BusinessException("删除失败" + f.getFileId());
            }
        }
        // 消息删除
        MessageExample messageExample = new MessageExample();
        messageExample.or().andProjectIdEqualTo(projectId).andIsDelEqualTo(0);
        List<Message> messages = messageMapper.selectByExample(messageExample);
        for (Message m : messages) {
            m.setIsDel(1);
            int i1 = messageMapper.updateByPrimaryKeySelective(m);
            if (i1 < 1) {
                log.error("删除失败");
                throw new BusinessException("删除失败" + m.getMessageId());
            }
        }
        return 1;
    }

    @Override
    public ProjectDetailVO projectDetail(long projectId) {
        ProjectDetailVO project = projectMapper.getProject(projectId);
        if (project == null) {
            log.error("项目不存在");
            throw new BusinessException("项目不存在");
        }
        List<FileVO> files = projectMapper.files(projectId);
        project.setFiles(files);
        return project;
    }

    @Override
    public List<ParticipationVO> projectParticipationList(long projectId) {
        return participationMapper.projectParticipationList(projectId);
    }

    @Override
    public int projectParticipationDel(long participationId) {
        Participation p = participationMapper.selectByPrimaryKey(participationId);
        if (p == null) {
            log.error("人员不存在");
            throw new BusinessException("人员不存在");
        }
        if (p.getIsDel() == 1 || p.getIsExecuted() ==0) {
            log.error("删除错误");
            throw new BusinessException("删除错误");
        }
        p.setIsDel(1);
        p.setUpdateTime(new Date());
        return  participationMapper.updateByPrimaryKeySelective(p);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int projectParticipationReplace(Participation participation) {
        Participation participation1 = participationMapper.selectByPrimaryKey(participation.getId());
        if (participation1 == null || participation1.getIsExecuted()==0 || participation1.getIsDel() == 1) {
            log.error("人员不存在");
            throw new BusinessException("人员不存在");
        }
        if (!participation1.getProjectId().equals(participation.getProjectId())) {
            log.error("项目不对应");
            throw new BusinessException("项目不对应");
        }
        // 查询当前职位人员未完成任务
        TaskExample taskExample = new TaskExample();
        taskExample.or().andIsDelEqualTo(0)
                .andProjectIdEqualTo(participation.getProjectId())
                .andExecuteUseridEqualTo(participation1.getUserid())
                .andIsCompletedEqualTo(0);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        // 替换任务
        for (Task task : tasks) {
            task.setExecuteUserid(participation.getUserid());
            task.setStation(participation.getStation());
            int i = taskMapper.updateByPrimaryKeySelective(task);
            if ( i < 1) {
                log.error("替换任务出错"+task.getTaskId());
                throw new BusinessException("替换任务出错"+task.getTaskId());
            }
        }
        // 替换人员
        participation1.setUserid(participation.getUserid());
        participation1.setName(participation.getName());
        participation1.setStation(participation.getStation());
        participation1.setUpdateTime(new Date());
        int i = participationMapper.updateByPrimaryKeySelective(participation1);
        if (i < 1) {
            log.error("替换失败");
            throw new BusinessException("替换失败");
        }
        return 1;
    }

    @Override
    public int projectParticipationAdd(Participation participation) {
        participation.setCreateTime(new Date());
        participation.setUpdateTime(new Date());
        return participationMapper.insert(participation);
    }

    @Override
    public PageInfo<TaskVO> taskList(long projectId, int pageSize, int pageNum) {
        PageHelper.offsetPage(pageNum,pageSize);
        List<TaskVO> userTaskList = taskMapper.getUserTaskList(null, projectId, null, null);
        PageInfo<TaskVO> pageInfo = new PageInfo<>(userTaskList);
        return pageInfo;
    }

    @Override
    public int taskAdd(Task task) {
        task.setCreateTime(new Date());
        task.setUpdateTime(new Date());
        int insert = taskMapper.insert(task);
        if (insert < 1) {
            log.error("添加失败");
            throw new BusinessException("添加失败");
        }
        return insert;
    }

    @Override
    public int taskDel(long taskId) {
        Task task = taskMapper.selectByPrimaryKey(taskId);
        if (task == null || task.getIsDel() == 1) {
            log.error("任务不存在");
            throw new BusinessException("任务不存在");
        }
        task.setIsDel(1);
        task.setUpdateTime(new Date());
        int i = taskMapper.updateByPrimaryKeySelective(task);
        if (i < 1) {
            log.error("删除失败");
            throw new BusinessException("删除失败");
        }
        return i;
    }

    @Override
    public PageInfo<MessageVO> messageList(long projectId, int pageSize, int pageNum) {
        PageHelper.offsetPage(pageNum,pageSize);
        List<MessageVO> list = messageMapper.getList(projectId);
        PageInfo<MessageVO> r = new PageInfo<>(list);
        return r;
    }

    @Override
    public int messageAdd(Message message) {
        message.setCreateTime(new Date());
        message.setUodateTime(new Date());
        int i = messageMapper.insertSelective(message);
        if (i < 1) {
            log.error("添加失败");
            throw new BusinessException("添加失败");
        }
        return i;
    }

    @Override
    public int messageDel(long messageId) {
        Message message = messageMapper.selectByPrimaryKey(messageId);
        if (message == null || message.getIsDel() == 1) {
            log.error("消息不存在");
            throw new BusinessException("消息不存在");
        }
        message.setIsDel(1);
        message.setUodateTime(new Date());
        int i = messageMapper.updateByPrimaryKeySelective(message);
        if (i < 0) {
            log.error("删除失败");
            throw new BusinessException("删除失败");
        }
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int projectAdd(ProjectAddVO projectAddVO) {
         // 参数检测
        String error = checkProjectParams(projectAddVO);
        if (error != null) {
            log.error(error);
            throw new BusinessException(error);
        }
        // 参数设置
        Project project = getAddProject(projectAddVO);
        // 添加
        int insert = projectMapper.insert(project);
        if (insert < 1) {
            log.error("添加项目失败");
            throw new BusinessException("添加项目失败");
        }
        int insert1 = alphaMapper.insert(projectAddVO.getAlpha());
        if (insert1 < 1) {
            log.error("添加版本失败");
            throw new BusinessException("添加版本失败");
        }
        return 1;
    }

    private Project getAddProject(ProjectAddVO projectAddVO) {
        Project project = new Project();
        project.setVersionName(projectAddVO.getVersionName());
        project.setUpdateTime(new Date());
        project.setCreateTime(new Date());
        project.setVersionId(projectAddVO.getVersionId());
        project.setContractName(projectAddVO.getContractName());
        project.setContractTel(projectAddVO.getContractTel());
        project.setManageUserid(projectAddVO.getManagerUserid());
        project.setManageUsername(projectAddVO.getManagerName());
        project.setData(projectAddVO.getData());
        project.setRank(projectAddVO.getRank());
        project.setBegin(projectAddVO.getBegin());
        project.setEnd(projectAddVO.getEnd());
        project.setProjectName(projectAddVO.getProjectName());
        return null;
    }

    private String checkProjectParams(ProjectAddVO projectAddVO) {
        String error = null;
        if (projectAddVO.getProjectName() == null || projectAddVO.getProjectName().equals("")) {
            error = "项目名称为空";
            return error;
        }
        if (projectAddVO.getBegin() == null || projectAddVO.getBegin().getTime() < new Date().getTime()) {
            error = "开始时间错误";
            return error;
        }
        if (projectAddVO.getEnd() == null || projectAddVO.getEnd().getTime() < new Date().getTime()) {
            error = "结束时间错误";
            return error;
        }
        if (projectAddVO.getContractName() == null || projectAddVO.getContractName().equals("")) {
            error = "联系人为空";
            return error;
        }
        if (projectAddVO.getContractTel() == null || projectAddVO.getContractTel().equals("")) {
            error = "联系方式为空";
            return error;
        }
        if (projectAddVO.getVersionName() == null || projectAddVO.getVersionName().equals("")) {
            error = "版本名称为空";
            return error;
        }
        Version version = this.versionMapper.selectByPrimaryKey(projectAddVO.getVersionId());
        if (version == null || version.getId() != 1 || !version.getVaersion().equals(projectAddVO.getVersionName())) {
            error = "版本错误";
            return error;
        }
        if (projectAddVO.getManagerName() == null || projectAddVO.getManagerName().equals("")) {
            error = "负责人姓名";
            return error;
        }
        User user = userMapper.selectByPrimaryKey(projectAddVO.getManagerUserid());
        if (user == null || !user.getName().equals(projectAddVO.getManagerName())) {
            error = "负责人错误";
            return error;
        }
        if (projectAddVO.getRank() == null) {
            error = "星级为空";
        }
        return error;
    }

    @Override
    public int jump(ProjectVersionVO projectVersionVO) {
        Project project = projectMapper.selectByPrimaryKey(projectVersionVO.getProjectId());
        if (project == null) {
            log.error("项目不存在");
            throw new BusinessException("项目不存在");
        }
        project.setUpdateTime(new Date());
        project.setVersionId(projectVersionVO.getVersionId());
        project.setVersionName(projectVersionVO.getVersion());
        int i = projectMapper.updateByPrimaryKeySelective(project);
        int j = 0;
        if (projectVersionVO.getVersionId().equals(projectVersionVO.getBeta().getVersionId())) {
            Beta beta = projectVersionVO.getBeta();
            beta.setUpdateTime(new Date());
            beta.setCreateTime(new Date());
            beta.setProjectId(project.getProjectId());
            j = betaMapper.insert(beta);
        }else if(projectVersionVO.getVersionId().equals(projectVersionVO.getMaster().getVersionId())) {
            Master master = projectVersionVO.getMaster();
            master.setUpdateTime(new Date());
            master.setCreateTime(new Date());
            master.setProjectId(project.getProjectId());
            j = masterMapper.insert(master);
        }
        if ( i < 1 || j < 1) {
            log.error("进入下一阶段失败");
            throw new BusinessException("进入下一阶段失败");
        }
        return 0;
    }
}
