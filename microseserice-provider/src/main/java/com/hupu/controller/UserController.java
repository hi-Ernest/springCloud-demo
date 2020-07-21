package com.hupu.controller;

import com.hupu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/server/getUser")
    public String getUserInfoById(@RequestParam("id") Long id) {
        return userService.getUserInfo(id);
    }


    //发现已注册的有哪些服务
    @GetMapping(value = "/server/discovery")
    public Object discovery() {

        List<String> list = discoveryClient.getServices();
        System.out.println(list);
        System.out.println("-----------------------");
        List<ServiceInstance> sviList = discoveryClient.getInstances("MICROSERVICECLOUD-USER");

        for (ServiceInstance element : sviList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return discoveryClient;

    }
}
