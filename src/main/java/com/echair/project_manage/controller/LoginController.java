package com.echair.project_manage.controller;

import com.echair.project_manage.common.pojo.dto.UserAddDTO;
import com.echair.project_manage.common.pojo.dto.UserDTO;
import com.echair.project_manage.common.pojo.vo.UserVO;
import com.echair.project_manage.common.result.Response;
import com.echair.project_manage.service.LoginService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/2 14:16
 **/
@RestController
public class LoginController {
    @Resource
    LoginService loginService;
    @PostMapping("/login")
    public Response login(@RequestBody UserDTO userDTO) {
//        Assert.notNull(userDTO.getUsername(), "username is null");
//        Assert.notNull(userDTO.getPassword(), "password is null");
        if (userDTO.getPassword() == null) {
            throw new RuntimeException("密码为空");
        }
        Map<String, Object> login = loginService.login(userDTO);
        if (login == null) {
            return Response.fail("用户名或密码错误");
        }
        return Response.success(login);
    }
    @PostMapping("/login1")
    public Response login1(@RequestBody UserDTO userDTO) {
        Assert.notNull(userDTO.getUsername(), "username is null");
        Assert.notNull(userDTO.getPassword(), "password is null");
        Map<String, Object> login = loginService.loginDefault(userDTO);
        if (login == null) {
            return Response.fail("用户名或密码错误");
        }
        return Response.success(login);
    }
    @PostMapping("/login2")
    public Response login2(@RequestBody UserDTO userDTO) {
        Assert.notNull(userDTO.getUsername(), "username is null");
        Assert.notNull(userDTO.getPassword(), "password is null");
        Map<String, Object> login = loginService.login1(userDTO);
        if (login == null) {
            return Response.fail("用户名或密码错误");
        }
        return Response.success(login);
    }
    @PostMapping("/alterPwd")
    public Response alterPwd() {
        return null;
    }

    /**
     * 添加用户
     * @param userAddDTO
     * @return
     */
    @PostMapping("/addUser")
    public Response addUser(@RequestBody UserAddDTO userAddDTO) {
        Assert.notNull(userAddDTO.getUsername(), "username is null");
        Assert.notNull(userAddDTO.getPassword(), "password is null");
        Assert.notNull(userAddDTO.getRoleId(),"roleId is null");
        Assert.notNull(userAddDTO.getName(),"name is null");
        int i = loginService.addUser(userAddDTO);
        if ( i > 0) {
            return Response.success("ok");
        }
        return Response.fail("添加失败");
    }
}
