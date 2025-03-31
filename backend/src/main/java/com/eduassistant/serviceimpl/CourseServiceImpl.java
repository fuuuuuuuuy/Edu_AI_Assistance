package com.eduassistant.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eduassistant.entity.Course;
import com.eduassistant.mapper.CourseMapper;
import com.eduassistant.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public IPage<Course> findAll(Page<Course> page) {
        return courseMapper.findAll(page);
    }

    @Override
    public List<Course> findAll() {
        return courseMapper.selectList(null);
    }

    @Override
    public IPage<Course> searchByCourseName(String keyword,Page<Course> page) {return courseMapper.searchByCourseName(page,keyword);}


    @Override
    public List<Course> searchByCourseName(String keyword) {return courseMapper.searchByCourseName(keyword);}
//    searchByCourseName(String keyword)

    @Override
    public IPage<Course> findByPlatform(String platform, Page<Course> page) {return courseMapper.findByPlatform(page,platform);}


    @Override
    public List<Course> findByPlatformlist(String platform) {return courseMapper.findByPlatformlist(platform);}

    @Override
    public Course findById(Integer courseId) {
        return courseMapper.selectById(courseId);
    }

    @Override
    public Course add(Course course) {
        courseMapper.insert(course);
        return course;
    }

    @Override
    public Course update(Course course) {
        courseMapper.updateById(course);
        return course;
    }

    @Override
    public void deleteById(Integer courseId) {
        courseMapper.deleteById(courseId);
    }
}