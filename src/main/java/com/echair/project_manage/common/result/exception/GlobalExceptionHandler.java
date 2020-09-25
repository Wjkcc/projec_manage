package com.echair.project_manage.common.result.exception;//package com.hykj.newmore.result.exception;
//
//import com.hykj.newmore.result.Response;
//import org.apache.tomcat.util.http.fileupload.FileUploadBase;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.multipart.MaxUploadSizeExceededException;
//import org.springframework.web.multipart.MultipartException;
//
///**
// * @description:
// * @author: wjk
// * @date: 2020/8/14 15:51
// **/
////@RestControllerAdvice
//public class GlobalExceptionHandler {
//    static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    @ExceptionHandler(value = MultipartException.class)
//    public @ResponseBody
//    Response handleBusinessException(MaxUploadSizeExceededException ex) {
////        String msg;
////        if (ex.getCause().getCause() instanceof FileUploadBase.FileSizeLimitExceededException) {
////            logger.error(ex.getMessage());
////            msg = "上传文件过大[单文件大小不得超过10M]";
////        } else if (ex.getCause().getCause() instanceof FileUploadBase.SizeLimitExceededException) {
////            logger.error(ex.getMessage());
////            msg = "上传文件过大[总上传文件大小不得超过10M]";
////        } else {
////            msg = "上传文件失败";
////        }
//        logger.error("文件超过100mb");
//        return Response.fail("文件超过100MB");
//
//   }
//}
