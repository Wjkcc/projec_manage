package com.echair.project_manage.service;

import com.echair.project_manage.common.pojo.dto.ProjectDTO;
import com.echair.project_manage.common.pojo.vo.*;
import com.echair.project_manage.dao.model.Message;
import com.echair.project_manage.dao.model.Participation;
import com.echair.project_manage.dao.model.Task;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/14 14:48
 **/
public interface ProjectService {

    PageInfo<ProjectVO> projectList(ProjectDTO projectDTO);

    int projectDel(long projectId);

    ProjectDetailVO projectDetail(long projectId);

    List<ParticipationVO> projectParticipationList(long projectId);

    int projectParticipationDel(long participationId);

    int projectParticipationReplace(Participation participation);

    int projectParticipationAdd(Participation participation);

    PageInfo<TaskVO> taskList(long projectId, int pageSize, int pageNum);

    int taskAdd(Task task);

    int taskDel(long taskId);

    PageInfo<MessageVO> messageList(long projectId, int pageSize, int pageNum);

    int messageAdd(Message message);

    int messageDel(long messageId);

    int projectAdd(ProjectAddVO projectAddVO);

    int jump(ProjectVersionVO projectVersionVO);

}
