package com.echair.project_manage.common.result;

public enum ResultCode {

    SUCCESS(200,"SUCCESS"),
    ERROR(0, "ERROR");

    /**
     * 错误编码
     */
    private Integer code;
    /**
     * 错误编码描述
     */
    private String content;

    private ResultCode(Integer code, String content) {
        this.code = code;
        this.content = content;
    }
}
