package com.eduassistant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eduassistant.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    @Select("SELECT * FROM courses WHERE course_name LIKE CONCAT('%', #{keyword}, '%')")
    List<Course> searchByCourseName(String keyword);
    //分页的mapper：IPage<Course>必须要page参数在前面？
    @Select("SELECT * FROM courses WHERE course_name LIKE CONCAT('%', #{keyword}, '%')")
    IPage<Course> searchByCourseName(Page<Course> page,String keyword);

    @Select("SELECT * FROM courses WHERE course_platform = #{platform}")
    IPage<Course> findByPlatform(Page<Course> page,String platform);

    @Select("SELECT * FROM courses WHERE course_platform = #{platform}")
    List<Course> findByPlatformlist(String platform);

    @Select("SELECT * FROM courses")
    IPage<Course> findAll(Page<Course> page);
}