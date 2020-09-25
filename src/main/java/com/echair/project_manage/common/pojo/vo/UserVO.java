package com.echair.project_manage.common.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/2 14:19
 **/
@Data
public class UserVO {
    private String userid;
    private String name;
    private String avater;
    private Long roleId;
    private String roleName;
    private List<AssessVO> assess;

}
