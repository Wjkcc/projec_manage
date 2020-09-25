package com.echair.project_manage.common.config.app;

import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @description:
 * @author: wjk
 * @date: 2020/8/29 16:58
 **/
@Configuration
@MapperScan(basePackages="com.**.dao.mapper") //扫描mapper可以不写@Mapper注解
public class ApplicationConfig {
    /*
   分页配置
    */
    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
