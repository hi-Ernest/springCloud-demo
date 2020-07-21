package com.hupu.controller;

import com.hupu.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController_Consumer {

    @Autowired
    private UserFeign userFeign;

    @GetMapping(value = "/consumer/user")
    String getUserInfo(@RequestParam("id") Long id) {
        //System.out.println("----------------调用Feign-----------");
        return userFeign.getUserInfo(id);
    }




}
