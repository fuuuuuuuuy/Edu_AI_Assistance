package com.eduassistant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eduassistant.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    IPage<Course> findAll(Page<Course> page);
    IPage<Course> searchByCourseName(String keyword,Page<Course> page);

    List<Course> searchByCourseName(String keyword);

    IPage<Course> findByPlatform(String platform, Page<Course> page);

    List<Course> findByPlatformlist(String platform);

    Course findById(Integer courseId);
    Course add(Course course);
    Course update(Course course);
    void deleteById(Integer courseId);
}