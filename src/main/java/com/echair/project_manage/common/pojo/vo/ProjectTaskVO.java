package com.echair.project_manage.common.pojo.vo;

import com.echair.project_manage.common.pojo.base.TimestampBase;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/8 15:09
 **/
@Data
public class ProjectTaskVO extends TimestampBase {
    private long projectId;
    private String versionName;
    private List<TaskVO> taskList;
}
