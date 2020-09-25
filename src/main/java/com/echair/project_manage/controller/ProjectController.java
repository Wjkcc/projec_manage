package com.echair.project_manage.controller;

import com.echair.project_manage.common.pojo.dto.ProjectDTO;
import com.echair.project_manage.common.pojo.vo.ProjectDetailVO;
import com.echair.project_manage.common.pojo.vo.ProjectVO;
import com.echair.project_manage.common.result.Response;
import com.echair.project_manage.common.result.exception.BusinessException;
import com.echair.project_manage.dao.model.Message;
import com.echair.project_manage.dao.model.Participation;
import com.echair.project_manage.dao.model.Task;
import com.echair.project_manage.service.ProjectService;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.lang.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/14 14:27
 **/
@RestController
public class ProjectController {
    @Resource
    ProjectService projectService;
    /**
     * 项目管理项目列表
     * @param projectDTO
     * @return
     */
    @PostMapping("/project/list")
    public Response projectList(@RequestBody ProjectDTO projectDTO) {
        PageInfo<ProjectVO> projectVOPageInfo = projectService.projectList(projectDTO);
        return Response.success(projectVOPageInfo);
    }

    /**
     * 项目管理项目删除
     * @param projectId
     * @return
     */
    @PostMapping("/project/del")
    public Response projectDel(Long projectId) {
        Assert.notNull(projectId,"projectId is null");
        int i = projectService.projectDel(projectId);
        if (i > 0) {
            return Response.success("");
        }
        return Response.fail("删除失败");
    }

    /**
     * 项目管理项目详情
     * @param projectId
     * @return
     */
    @GetMapping("/project/detail")
    public Response projectDetail(Long projectId) {
        Assert.notNull(projectId,"projectId is null");
        ProjectDetailVO projectDetailVO = projectService.projectDetail(projectId);
        if (projectDetailVO == null) {
            return Response.fail("查询为空");
        }
        return Response.success(projectDetailVO);
    }

    /**
     * 项目管理参与人员列表
     * @param projectId
     * @return
     */
    @GetMapping("/project/detail/participation/list")
    public Response projectParticipationList(Long projectId) {
        Assert.notNull(projectId,"projectId is null");
        return Response.success(projectService.projectParticipationList(projectId));
    }

    /***
     * 项目管理人员删除
     * @param participationId
     * @return
     */
    @PostMapping("/project/detail/participation/del")
    public Response projectParticipationDel(Long participationId) {
        Assert.notNull(participationId,"participationId is null");
        int i = projectService.projectParticipationDel(participationId);
        if (i > 0) {
            return Response.success("");
        }
        return Response.fail("删除失败");
    }

    /**
     * 项目管理人员替换
     * @param participation
     * @return
     */
    @PostMapping("/project/detail/participation/replace")
    public Response projectParticipationReplace(@RequestBody Participation participation) {
        int i = projectService.projectParticipationReplace(participation);
        if (i > 0) {
            return Response.success("");
        }
        return Response.fail("替换失败");
    }

    /**
     * 项目管理人员添加
     * @param participation
     * @return
     */
    @PostMapping("/project/detail/participation/add")
    public Response projectParticipationAdd(@RequestBody Participation participation) {
        int i = projectService.projectParticipationAdd(participation);
        if (i > 0) {
            return Response.success("");
        }
        return Response.fail("添加失败");
    }

    /**
     * 任务列表
     * @param projectId
     * @param pageSize
     * @param pageNum
     * @return
     */
    @GetMapping("/project/detail/task/list")
    public Response projectTaskList(Long projectId,Integer pageSize,Integer pageNum) {
        Assert.notNull(projectId, "projectId is null");
        Assert.notNull(pageNum, "pageNum is null");
        Assert.notNull(pageSize, "pageSize is null");
        return Response.success(projectService.taskList(projectId,pageSize,pageNum));
    }

    /**
     * 任务添加
     * @param task
     * @return
     */
    @PostMapping("/project/detail/task/add")
    public Response projectTaskAdd(@RequestBody Task task) {
        int i = projectService.taskAdd(task);
        if ( i < 1) {
            return Response.fail("添加失败");
        }
        return Response.success("添加成功");
    }
    /**
     * 任务删除
     * @param taskId
     * @return
     */
    @PostMapping("/project/detail/task/del")
    public Response projectTaskDel(Long taskId) {
        Assert.notNull(taskId, "taskId is null");
        int i = projectService.taskDel(taskId);
        if ( i < 1) {
            return Response.fail("删除失败");
        }
        return Response.success("删除成功");
    }

    /**
     * 消息列表
     * @param projectId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/project/detail/message/list")
    public Response projectMessageList(Long projectId, Integer pageNum, Integer pageSize) {
        Assert.notNull(projectId, "projectId is null");
        Assert.notNull(pageNum, "pageNum is null");
        Assert.notNull(pageSize, "pageSize is null");
        return Response.success(projectService.messageList(projectId,pageSize,pageNum));
    }

    /**
     * 消息添加
     * @param message
     * @return
     */
    @GetMapping("/project/detail/message/add")
    public Response projectMessageAdd(@RequestBody Message message) {
        String error = messageCheck(message);
        if (error != null) {
            throw new BusinessException(error);
        }
        int i = projectService.messageAdd(message);
        if (i < 1) {
            return Response.fail("添加失败");
        }
        return Response.success("添加成功");
    }
    
    private String messageCheck(Message message) {
        if (message.getAvater() == null) {
            return "avater is null";
        }
        if (message.getName() == null) {
            return "name is null";
        }
        if (message.getUserid() == null) {
            return "userid is null";
        }
        if (message.getContent() == null) {
            return "content is null";
        }
        return null;
    }

    /**
     * 消息删除
     * @param messageId
     * @return
     */
    @GetMapping("/project/detail/message/del")
    public Response projectMessageDel(Long messageId) {
        Assert.notNull(messageId,"messageId is null");
        int i = projectService.messageDel(messageId);
        if (i < 1) {
            return Response.fail("删除失败");
        }
        return Response.success("删除失败");
    }
}
