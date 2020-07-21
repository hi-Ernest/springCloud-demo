package com.hupu.service.impl;

import com.hupu.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getUserInfo(Long id) {
        return "this user id is " + id;
    }
}
