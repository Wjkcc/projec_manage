package com.echair.project_manage.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.echair.project_manage.common.TokenUtils;
import com.echair.project_manage.common.cache.MapCache;
import com.echair.project_manage.common.context.UserContext;
import com.echair.project_manage.common.pojo.vo.UserVO;
import com.echair.project_manage.common.result.Response;
import com.echair.project_manage.common.result.exception.BusinessException;
import com.echair.project_manage.dao.mapper.UserMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;

@Data
@Component
@Slf4j
public class Interceptor implements HandlerInterceptor {
    @Resource
    TokenUtils tokenUtils;
    @Resource
    UserMapper userMapper;
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // token检验
        String token = request.getHeader("token");
        if (token == null) {
            response.getWriter().println(JSON.toJSON(Response.fail("token is null")));
            return false;
        }
        String userid = null;
        try {
            userid = tokenUtils.checkToken(token);
        }catch(Exception e) {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(JSON.toJSON(Response.fail(e.getMessage())));
            return false;
        }
        // 获取用户信息放到当前线程
        if (userid != null) {
            /**
             * 缓存中获取用户信息，不存在测查询数据库
             */
            UserVO userVO = MapCache.getInstance().getCache(userid);
            if (null == userVO) {
                userVO = userMapper.getUser1(userid);
                if (userVO == null) {
                    log.error("登录错误，用户不存在");
                    throw new BusinessException("登录错误，用户不存在");
                }
                // 添加过期时间1个小时
                MapCache.getInstance().setCache(userVO,60 * 60* 1000L);
            }
            // 线程中存入用户信息
            UserContext.setUser(userVO);
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(JSON.toJSON("未登录"));
        return false;
//如果设置为true时，请求将会继续执行后面的操作
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//         System.out.println("执行了TestInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        System.out.println("执行了TestInterceptor的afterCompletion方法");
        System.out.println("ccccccccccccc");
        UserContext.remove();
    }
}
