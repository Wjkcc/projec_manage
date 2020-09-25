package com.echair.project_manage.common.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/14 14:16
2 **/
@Data
public class ParticipationVO {
    private Long participationId;
    private Long projectId;
    private String name;
    private String userid;
    private Date createTime;
    private String station;
//    private Integer stationId;
}
