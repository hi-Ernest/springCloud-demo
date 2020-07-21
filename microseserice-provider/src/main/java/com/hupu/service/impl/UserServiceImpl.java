package com.hupu.service.impl;

import com.hupu.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getUserInfo(Long id) {
//        System.out.println();
//        System.out.println("server getUserInfo");
//        System.out.println();
        return "this user id is " + id + " in myServer";
    }
}
