package com.echair.project_manage.common.config.login;

/**
 * @description:
 * @author: wjk
 * @date: 2020/8/29 17:00
 **/

import com.echair.project_manage.common.interceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Description:拦截器配置
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Resource
    Interceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册TestInterceptor拦截器
//        Interceptor i = new Interceptor();
//        i.setRequestContext(requestContext);
        InterceptorRegistration registration = registry.addInterceptor(interceptor);
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/login1");
    }
}
