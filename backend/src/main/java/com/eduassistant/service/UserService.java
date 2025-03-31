package com.eduassistant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eduassistant.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    IPage<User> findAll(Page<User> page);
    User findById(Integer userId);
    User findByEmail(String email);
    User add(User user);
    User update(User user);
    void deleteById(Integer userId);
}