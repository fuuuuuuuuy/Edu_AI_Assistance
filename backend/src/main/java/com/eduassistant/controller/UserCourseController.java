package com.eduassistant.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eduassistant.entity.ApiResult;
import com.eduassistant.entity.UserCourse;
import com.eduassistant.service.UserCourseService;
import com.eduassistant.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-courses")
public class UserCourseController {
    @Autowired
    private UserCourseService userCourseService;

    @GetMapping
    public ApiResult<List<UserCourse>> findAll() {
        return ApiResultHandler.success(userCourseService.findAll());
    }

    @GetMapping("/page")
    public ApiResult<IPage<UserCourse>> findAll(@RequestParam Integer page, @RequestParam Integer size) {
        Page<UserCourse> userCoursePage = new Page<>(page, size);
        return ApiResultHandler.success(userCourseService.findAll(userCoursePage));
    }

    @GetMapping("/{userCourseId}")
    public ApiResult<UserCourse> findById(@PathVariable Integer userCourseId) {
        return ApiResultHandler.success(userCourseService.findById(userCourseId));
    }

    @GetMapping("/user/{userId}")
    public ApiResult<List<UserCourse>> findByUserId(@PathVariable Integer userId) {
        return ApiResultHandler.success(userCourseService.findByUserId(userId));
    }

    @GetMapping("/course/{courseId}")
    public ApiResult<List<UserCourse>> findByCourseId(@PathVariable Integer courseId) {
        return ApiResultHandler.success(userCourseService.findByCourseId(courseId));
    }

    @PostMapping
    public ApiResult<UserCourse> add(@RequestBody UserCourse userCourse) {
        return ApiResultHandler.success(userCourseService.add(userCourse));
    }

    @PutMapping
    public ApiResult<UserCourse> update(@RequestBody UserCourse userCourse) {
        return ApiResultHandler.success(userCourseService.update(userCourse));
    }

    @DeleteMapping("/{userCourseId}")
    public ApiResult<String> deleteById(@PathVariable Integer userCourseId) {
        userCourseService.deleteById(userCourseId);
        return ApiResultHandler.success("删除成功");
    }
}