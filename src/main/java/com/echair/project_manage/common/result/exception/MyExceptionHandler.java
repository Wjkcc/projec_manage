package com.echair.project_manage.common.result.exception;

import com.echair.project_manage.common.result.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * @description:
 * @author: wjk
 * @date: 2020/8/14 15:56
 **/
@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {
    @ExceptionHandler(value =Exception.class)
    public Response exceptionHandler(Exception e) {
        e.printStackTrace();
        String s = "未知异常！原因是:" + e.getStackTrace().toString();
        log.error(s);
        return Response.fail(e.getMessage());
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public Response handleBusinessException(MaxUploadSizeExceededException ex) {
        ex.printStackTrace();
        String s = "未知异常！原因是:" + ex.getStackTrace().toString();
        log.error(s);
        log.error("文件超过100mb");
        return Response.fail("文件超过100MB");
    }
}
