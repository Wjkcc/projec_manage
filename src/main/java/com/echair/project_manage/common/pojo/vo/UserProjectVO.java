package com.echair.project_manage.common.pojo.vo;

import lombok.Data;

/**
 * @description: 用户项目列表
 * @author: wjk
 * @date: 2020/9/7 16:52
 **/
@Data
public class UserProjectVO {
    private String projectName;
    private Long projectId;
    private Integer rank;
    private Integer taskSize;
}
