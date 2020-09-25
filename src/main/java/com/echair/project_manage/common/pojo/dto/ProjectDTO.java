package com.echair.project_manage.common.pojo.dto;

import com.echair.project_manage.common.pojo.base.DoubleBase;
import com.echair.project_manage.common.pojo.base.TimestampBase;
import lombok.Data;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/14 13:56
 **/
@Data
public class ProjectDTO extends DoubleBase {
    private String projectName;
    private String userid;
    private String versionName;
    private String participation;
}
