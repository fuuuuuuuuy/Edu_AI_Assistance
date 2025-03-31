package com.eduassistant.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eduassistant.entity.ApiResult;
import com.eduassistant.entity.User;
import com.eduassistant.service.UserService;
import com.eduassistant.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ApiResult<List<User>> findAll() {
        return ApiResultHandler.success(userService.findAll());
    }

    @GetMapping("/page")
    public ApiResult<IPage<User>> findAll(@RequestParam Integer page, @RequestParam Integer size) {
        Page<User> userPage = new Page<>(page, size);
        return ApiResultHandler.success(userService.findAll(userPage));
    }

    @GetMapping("/{userId}")
    public ApiResult<User> findById(@PathVariable Integer userId) {
        return ApiResultHandler.success(userService.findById(userId));
    }

    @PostMapping
    public ApiResult<User> add(@RequestBody User user) {
        try{
            User res = userService.add(user);
            System.out.println("user="+res);
            return ApiResultHandler.success(res);
        }catch (DuplicateKeyException e){
            System.out.println("e="+e);
            return ApiResultHandler.buildApiResult(400,"已存在用户",1);
        }
    }

    @PutMapping
    public ApiResult<User> update(@RequestBody User user) {
        return ApiResultHandler.success(userService.update(user));
    }

    @DeleteMapping("/{userId}")
    public ApiResult<String> deleteById(@PathVariable Integer userId) {
        userService.deleteById(userId);
        return ApiResultHandler.success("删除成功");
    }

}