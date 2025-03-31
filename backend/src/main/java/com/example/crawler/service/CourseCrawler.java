package com.example.crawler.service;

import com.example.crawler.model.Course;
import com.example.crawler.model.CourseDetail;
import java.util.List;

public interface CourseCrawler {
    /**
     * 爬取课程列表
     * @param page 页码
     * @param size 每页数量
     * @return 课程列表
     */
    List<Course> crawlCourses(int page, int size);

    /**
     * 爬取课程详情
     * @param courseUrl 课程URL
     * @return 课程详情
     */
    CourseDetail crawlCourseDetail(String courseUrl);

    /**
     * 获取平台名称
     * @return 平台名称
     */
    String getPlatformName();
} 