package com.eduassistant.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eduassistant.entity.UserCourse;
import com.eduassistant.mapper.UserCourseMapper;
import com.eduassistant.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {
    @Autowired
    private UserCourseMapper userCourseMapper;

    @Override
    public List<UserCourse> findAll() {
        return userCourseMapper.selectList(null);
    }

    @Override
    public IPage<UserCourse> findAll(Page<UserCourse> page) {
        return userCourseMapper.findAll(page);
    }

    @Override
    public UserCourse findById(Integer userCourseId) {
        return userCourseMapper.selectById(userCourseId);
    }

    @Override
    public List<UserCourse> findByUserId(Integer userId) {
        return userCourseMapper.findByUserId(userId);
    }

    @Override
    public List<UserCourse> findByCourseId(Integer courseId) {
        return userCourseMapper.findByCourseId(courseId);
    }

    @Override
    public UserCourse add(UserCourse userCourse) {
        userCourseMapper.insert(userCourse);
        return userCourse;
    }

    @Override
    public UserCourse update(UserCourse userCourse) {
        userCourseMapper.updateById(userCourse);
        return userCourse;
    }

    @Override
    public void deleteById(Integer userCourseId) {
        userCourseMapper.deleteById(userCourseId);
    }
}