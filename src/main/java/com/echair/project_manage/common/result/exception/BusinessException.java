package com.echair.project_manage.common.result.exception;

/**
 * @description:
 * @author: wjk
 * @date: 2020/7/16 10:32
 **/
public class BusinessException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = -2109275973600373209L;

    private String errorCode;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String errorCode,String message) {
        super(message);
        this.setErrorCode(errorCode);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
