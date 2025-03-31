package com.example.crawler.controller;

import com.example.crawler.model.Course;
import com.example.crawler.model.CourseDetail;
import com.example.crawler.service.CourseCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/crawler")
public class CrawlerController {
    private static final Logger logger = LoggerFactory.getLogger(CrawlerController.class);
    
    @Autowired
    private CourseCrawler moocCrawler;

    @GetMapping("/courses")
    public List<Course> crawlCourses(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        logger.info("开始爬取课程列表，页码：{}，每页数量：{}", page, size);
        return moocCrawler.crawlCourses(page, size);
    }

    @GetMapping("/course/detail")
    public CourseDetail crawlCourseDetail(@RequestParam String courseUrl) {
        logger.info("开始爬取课程详情，课程URL：{}", courseUrl);
        return moocCrawler.crawlCourseDetail(courseUrl);
    }
} 