package com.echair.project_manage.controller;

import com.echair.project_manage.common.DayUtils;
import com.echair.project_manage.common.result.Response;
import com.echair.project_manage.dao.model.Message;
import com.echair.project_manage.dao.model.Task;
import com.echair.project_manage.service.TaskService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/8 15:58
 **/
@RestController
public class TaskController {
    @Resource
    TaskService taskService;
    /**
     * 任务项目查询
     * @return
     */
    @GetMapping("/task/project/list")
    public Response getProjectList() {
        Date today = DayUtils.getToday();
        Date tomorrow = DayUtils.getTomorrow();
        return Response.success(taskService.taskList(today, tomorrow));
    }

    /**
     * 任务列表
     * @param projectId
     * @return
     */
    @GetMapping("/task/task/list")
    public Response getTaskList(Long projectId) {
        Assert.notNull(projectId,"projectId is null");
        Date today = DayUtils.getToday();
        Date tomorrow = DayUtils.getTomorrow();
        return Response.success(taskService.getUserTaskList(projectId,today,tomorrow));
    }

    /**
     * 发送最新消息
     * @param message
     * @return
     */
    @PostMapping("/task/message/send")
    public Response sendMessage(@RequestBody Message message) {
        int i = taskService.sendMessage(message);
        if (i > 0) {
            return Response.success("");
        }
        return Response.fail("失败");

    }

    /**
     * 完成任务
     * @param taskId
     * @param remark
     * @return
     */
    @PostMapping("/task/task/completed")
    public Response completeTask(long taskId, String remark) {
        Assert.notNull(taskId,"taskId is null");
        int i = taskService.completeTask(taskId, remark);
        if (i > 0) {
            return Response.success("");
        }
        return Response.fail("失败");
    }

    /**
     * 获取最新消息
     * @param projectId
     * @return
     */
    @GetMapping("/task/message/getLatest")
    public Response getLatestMessage(Long projectId) {
        Assert.notNull(projectId,"projectId is null");
        return Response.success(taskService.getLatestMessage(projectId));
    }

    /**
     * 查看项目
     * @param projectId
     * @return
     */
    @GetMapping("/task/project/get")
    public Response getProject(Long projectId) {
        Assert.notNull(projectId,"projectId is null");

        return Response.success(taskService.getProject(projectId));
    }
}
