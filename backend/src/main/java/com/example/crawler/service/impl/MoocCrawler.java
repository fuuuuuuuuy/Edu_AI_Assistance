package com.example.crawler.service.impl;

import com.example.crawler.model.Course;
import com.example.crawler.model.CourseDetail;
import com.example.crawler.service.CourseCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MoocCrawler implements CourseCrawler {
    private static final Logger logger = LoggerFactory.getLogger(MoocCrawler.class);
    
    @Value("${crawler.mooc.base-url}")
    private String baseUrl;
    
    @Value("${crawler.mooc.user-agent}")
    private String userAgent;
    
    @Value("${crawler.mooc.delay}")
    private int delay;

    @Override
    public List<Course> crawlCourses(int page, int size) {
        List<Course> courses = new ArrayList<>();
        try {
            String url = String.format("%s/course/list?page=%d&size=%d", baseUrl, page, size);
            Document doc = Jsoup.connect(url)
                    .userAgent(userAgent)
                    .timeout(10000)
                    .get();
            
            Elements courseElements = doc.select(".course-card");
            for (Element element : courseElements) {
                Course course = new Course();
                course.setCourseName(element.select(".course-name").text());
                course.setCourseUrl(element.select("a").attr("href"));
                course.setCourseImageUrl(element.select("img").attr("src"));
                course.setCourseDescription(element.select(".course-desc").text());
                course.setCourseType("MOOC");
                course.setCoursePlatform("中国大学MOOC");
                courses.add(course);
                
                // 添加延迟，避免请求过快
                TimeUnit.SECONDS.sleep(delay);
            }
        } catch (Exception e) {
            logger.error("爬取MOOC课程列表失败", e);
        }
        return courses;
    }

    @Override
    public CourseDetail crawlCourseDetail(String courseUrl) {
        CourseDetail detail = new CourseDetail();
        try {
            Document doc = Jsoup.connect(courseUrl)
                    .userAgent(userAgent)
                    .timeout(10000)
                    .get();
            
            detail.setCourseName(doc.select(".course-name").text());
            detail.setCourseDescription(doc.select(".course-desc").text());
            detail.setCourseType("MOOC");
            detail.setCoursePlatform("中国大学MOOC");
            detail.setCourseUrl(courseUrl);
            
            // 添加延迟，避免请求过快
            TimeUnit.SECONDS.sleep(delay);
        } catch (Exception e) {
            logger.error("爬取MOOC课程详情失败", e);
        }
        return detail;
    }

    @Override
    public String getPlatformName() {
        return "中国大学MOOC";
    }
} 