package com.echair.project_manage.common.pojo.vo;

import com.echair.project_manage.dao.model.Beta;
import com.echair.project_manage.dao.model.Master;
import lombok.Data;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/24 15:17
 **/
@Data
public class ProjectVersionVO {
    private Long projectId;
    private Integer versionId;
    private String version;
    private Beta beta;
    private Master master;
}
