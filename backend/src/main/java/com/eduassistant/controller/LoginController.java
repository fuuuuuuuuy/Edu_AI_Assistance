package com.eduassistant.controller;

import com.eduassistant.entity.*;
import com.eduassistant.serviceimpl.LoginServiceImpl;
import com.eduassistant.serviceimpl.UserServiceImpl;
import com.eduassistant.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    private UserServiceImpl userservice;

    @PostMapping("/login")
    public ApiResult login(@RequestBody Login login) {

        String username = login.getUsername();
        String password = login.getPassword();

//        Enterprise enterpriseRes = loginService.adminLogin(username);
        User userRes = loginService.userLogin(username);
        if (userRes==null){
            return ApiResultHandler.buildApiResult(400, "该用户不存在", null);
        }
        else{
            if(userRes.getUserPassword().equals(password)){
                return ApiResultHandler.buildApiResult(200, "员工登录成功", userRes);
            }
            else return ApiResultHandler.buildApiResult(400, "密码错误", null);

        }
    }
}
