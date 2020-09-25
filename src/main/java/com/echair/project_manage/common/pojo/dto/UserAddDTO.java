package com.echair.project_manage.common.pojo.dto;

import lombok.Data;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/4 13:49
 **/
@Data
public class UserAddDTO extends UserDTO{
    private Long roleId;
    private String name;
}
