package com.echair.project_manage.service.impl;

import com.echair.project_manage.common.DayUtils;
import com.echair.project_manage.common.context.UserContext;
import com.echair.project_manage.common.pojo.vo.*;
import com.echair.project_manage.common.result.exception.BusinessException;
import com.echair.project_manage.dao.mapper.MessageMapper;
import com.echair.project_manage.dao.mapper.TaskMapper;
import com.echair.project_manage.dao.model.Message;
import com.echair.project_manage.dao.model.Task;
import com.echair.project_manage.dao.model.TaskExample;
import com.echair.project_manage.service.TaskService;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/8 16:12
 **/
@Service
@Slf4j
public class TaskServiceImpl implements TaskService {
    @Resource
    TaskMapper taskMapper;
    @Resource
    MessageMapper messageMapper;
    @Override
    public List<UserProjectVO> taskList(Date begin, Date end) {
        UserVO currentUser = UserContext.getCurrentUser();
        if (currentUser == null) {
            log.error("no login");
            throw new BusinessException("no login");
        }
        return taskMapper.getTaskProjectList(currentUser.getUserid(),begin,end);
    }

    @Override
    public List<TaskVO> getUserTaskList(long projectId, Date begin, Date end) {
        UserVO currentUser = UserContext.getCurrentUser();
        if (currentUser == null) {
            log.error("no login");
            throw new BusinessException("no login");
        }
        return taskMapper.getUserTaskList(currentUser.getUserid(),projectId,begin,end);
    }

    @Override
    public MessageVO getLatestMessage(long projectId) {
        return taskMapper.getLatestMessage(projectId);
    }

    @Override
    public ProjectTaskVO getProject(long projectId) {
        ProjectTaskVO projectTask = taskMapper.getProjectTask(projectId);
        if (projectTask == null) {
            log.error("project is not exit");
            throw new BusinessException("project is not exit");
        }
        List<TaskVO> userTaskList = taskMapper.getUserTaskList(null, projectId, null, null);
        projectTask.setTaskList(userTaskList);
        return projectTask;
    }

    @Override
    public int completeTask(long taskId, String remark) {
        UserVO currentUser = UserContext.getCurrentUser();
        if (currentUser == null) {
            log.error("no login");
            throw new BusinessException("no login");
        }
        // 判断任务是否是当前用户的
        Task task = taskMapper.selectByPrimaryKey(taskId);
        if (!currentUser.getUserid().equals(task.getExecuteUserid())) {
            log.error("task is wrong");
            throw new BusinessException("task is wrong");
        }
        // 判断任务是否存在或已经完成
        if (task.getIsDel() == 1 || task.getIsCompleted() == 1 || task.getStatus() != 0) {
            log.error("task is not exist or is completed");
            throw new BusinessException("task is not exist or is completed");
        }
        // 是否需要备注
        if (task.getEnd().getTime() < new Date().getTime() && remark == null) {
            log.error("remark is null");
            throw new BusinessException("remark is null");
        }
        // 完成要修改的参数
        int status = 1;
        int overdays = 0;
        if (task.getEnd().getTime() < new Date().getTime()) {
            status = 2;
            overdays = DayUtils.getDays(task.getEnd());
        }
        task.setIsCompleted(1);
        task.setUpdateTime(new Date());
        task.setStatus(status);
        task.setOverDays(overdays);
        task.setRemark(remark);
        return taskMapper.updateByPrimaryKeySelective(task);
    }

    @Override
    public int sendMessage(Message message) {
        UserVO currentUser = UserContext.getCurrentUser();
        if (currentUser == null) {
            log.error("no login");
            throw new BusinessException("no login");
        }
        message.setName(currentUser.getName());
        message.setCreateTime(new Date());
        message.setMessageId(null);
        message.setUodateTime(new Date());
        message.setUserid(currentUser.getUserid());
        return messageMapper.insert(message);
    }
}
