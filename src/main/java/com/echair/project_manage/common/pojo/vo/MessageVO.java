package com.echair.project_manage.common.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/8 15:14
 **/
@Data
public class MessageVO {
    /**
     *  "id":xx, //
     *       "username":"xxx",//
     *       "avater":"xxxx",//头像
     *       "content":"xxxx", // 内容
     *       "url":"xxx", // 链接
     *       "createTime":"2020-22-22", //
     */
    private Long messageId;
    private String name;
    private String content;
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    private String avater;
}
