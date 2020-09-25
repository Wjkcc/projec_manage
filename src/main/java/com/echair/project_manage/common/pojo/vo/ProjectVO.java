package com.echair.project_manage.common.pojo.vo;

import com.echair.project_manage.common.pojo.base.TimestampBase;
import lombok.Data;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/14 14:01
 **/
@Data
public class ProjectVO extends TimestampBase {
    private Long projectId;
    private String projectName;
    private String participation;
    private String messageContent;
}
