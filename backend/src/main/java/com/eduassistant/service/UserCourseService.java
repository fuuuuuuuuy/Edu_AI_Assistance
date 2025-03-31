package com.eduassistant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eduassistant.entity.UserCourse;

import java.util.List;

public interface UserCourseService {
    List<UserCourse> findAll();
    IPage<UserCourse> findAll(Page<UserCourse> page);
    UserCourse findById(Integer userCourseId);
    List<UserCourse> findByUserId(Integer userId);
    List<UserCourse> findByCourseId(Integer courseId);
    UserCourse add(UserCourse userCourse);
    UserCourse update(UserCourse userCourse);
    void deleteById(Integer userCourseId);
}