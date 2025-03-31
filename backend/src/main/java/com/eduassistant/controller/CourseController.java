package com.eduassistant.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eduassistant.entity.ApiResult;
import com.eduassistant.entity.Course;
import com.eduassistant.service.CourseService;
import com.eduassistant.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{page}/{size}")
    public IPage<Course> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Course> coursePage = new Page<>(page, size);
        return courseService.findAll(coursePage);
    }

    @GetMapping("/search/{keyword}/{page}/{size}")
    public ApiResult searchByCourseName(@PathVariable String keyword,@PathVariable Integer page, @PathVariable Integer size) {
//        Page<Course> coursePage = new Page<>(page, size);
//        return courseService.searchByCourseName(keyword,coursePage);
        Page<Course> coursePage = new Page<>(page,size);
        IPage<Course> res = courseService.searchByCourseName(keyword,coursePage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有keyword",res);
    }

    @GetMapping("/search/{keyword}")
    public List<Course> searchByCourseName(@PathVariable String keyword){
        return courseService.searchByCourseName(keyword);
    }
    @GetMapping("/Platform/{platform}/{page}/{size}")
    public ApiResult findByPlatform(@PathVariable String platform,@PathVariable Integer page, @PathVariable Integer size) {
//        Page<Course> coursePage = new Page<>(page, size);
//        return courseService.findByPlatform(platform,coursePage);
        Page<Course> coursePage = new Page<>(page,size);
        IPage<Course> res = courseService.findByPlatform(platform,coursePage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有平台",res);

    }

    @GetMapping("/Platformlist/{platform}")
    public List<Course> findByPlatformlist(@PathVariable String platform) {
        return courseService.findByPlatformlist(platform);
    }
    @GetMapping("/{courseId}")
    public Course findById(@PathVariable Integer courseId) {
        return courseService.findById(courseId);
    }

    @PostMapping
    public Course add(@RequestBody Course course) {
        return courseService.add(course);
    }

    @PutMapping
    public Course update(@RequestBody Course course) {
        return courseService.update(course);
    }

    @DeleteMapping("/{courseId}")
    public ApiResult deleteById(@PathVariable Integer courseId) {
        courseService.deleteById(courseId);
        return ApiResultHandler.success("删除成功");
    }
}