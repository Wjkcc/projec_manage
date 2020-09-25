package com.echair.project_manage.common.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/3 15:23
 **/
@Data
public class AssessVO {
    private Long assessId;
    private String assessName;
    private Long pid;
    private String url;
    private int type;
    private List<AssessVO> child;
}
