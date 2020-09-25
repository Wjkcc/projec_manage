package com.echair.project_manage.service;

import com.echair.project_manage.common.pojo.vo.MessageVO;
import com.echair.project_manage.common.pojo.vo.ProjectTaskVO;
import com.echair.project_manage.common.pojo.vo.TaskVO;
import com.echair.project_manage.common.pojo.vo.UserProjectVO;
import com.echair.project_manage.dao.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TaskService {
    /**
     * 当前用户项目列表
     * @param userid
     * @param begin
     * @param end
     * @return
     */
    List<UserProjectVO> taskList(Date begin, Date end);

    /**
     * 当前用户当前项目任务列表
     * @param usrid
     * @param projectId
     * @param begin
     * @param end
     * @return
     */
    List<TaskVO> getUserTaskList(long projectId, Date begin,  Date end);

    /**
     * 获取最新项目消息
     * @param projectId
     * @return
     */
    MessageVO getLatestMessage(long projectId);

    /**
     * 当前项目信息
     * @param projectId
     * @return
     */
    ProjectTaskVO getProject(long projectId);

    /**
     * 完成任务
     * @param taskId
     * @param remark
     * @return
     */
    int completeTask(long taskId,String remark);

    /**
     * 当前项目发送消息
     * @param message
     * @return
     */
    int sendMessage(Message message);


}
