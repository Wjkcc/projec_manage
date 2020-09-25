package com.echair.project_manage.controller;

import com.echair.project_manage.common.pojo.vo.UserVO;
import com.echair.project_manage.dao.mapper.UserMapper;
import com.echair.project_manage.dao.model.User;
import com.echair.project_manage.dao.model.UserExample;
import io.github.yedaxia.apidocs.ApiDoc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: wjk
 * @date: 2020/8/29 17:13
 **/
@RestController
public class TestController {
    @Resource
    UserMapper userMapper;

    /**
     *
     * @return
     */
    @GetMapping("/test")
    public Object abc() {
        UserVO user = userMapper.getUser("22");
        System.out.println("1111");
        return user;
    }
}
