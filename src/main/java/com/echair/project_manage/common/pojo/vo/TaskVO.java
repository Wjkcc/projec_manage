package com.echair.project_manage.common.pojo.vo;

import com.echair.project_manage.common.pojo.base.TimestampBase;
import lombok.Data;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/8 15:01
 **/
@Data
public class TaskVO extends TimestampBase {
    private long taskId;
    private String taskName;
    private int isCompleted;
    private int status;
    private int overDays;
    private String remark;
    private String executeName;
}
