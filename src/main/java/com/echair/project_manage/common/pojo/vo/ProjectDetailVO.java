package com.echair.project_manage.common.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/14 14:05
 **/
@Data
public class ProjectDetailVO extends ProjectVO{
    private String contractName;
    private String contractTel;
    private String versionName;
    private Integer versionId;
    private Integer rank;
    private String data;
    private List<FileVO> files;
}
