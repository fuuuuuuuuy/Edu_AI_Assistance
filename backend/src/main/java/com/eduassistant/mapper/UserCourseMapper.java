package com.eduassistant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eduassistant.entity.UserCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserCourseMapper extends BaseMapper<UserCourse> {
    @Select("SELECT * FROM user_courses WHERE user_id = #{userId}")
    List<UserCourse> findByUserId(Integer userId);

    @Select("SELECT * FROM user_courses WHERE course_id = #{courseId}")
    List<UserCourse> findByCourseId(Integer courseId);

    @Select("SELECT * FROM user_courses")
    IPage<UserCourse> findAll(Page<UserCourse> page);
}