package com.eduassistant.serviceimpl;

import com.eduassistant.entity.User;
import com.eduassistant.mapper.LoginMapper;
import com.eduassistant.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

//    @Override
//    public Enterprise adminLogin(String username) {
//        return loginMapper.adminLogin(username);
//    }

    @Override
    public User userLogin(String username) {
        return loginMapper.userLogin(username);
    }

}
