package com.hupu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "MICROSERVICE-PROVIDER-USER")
public interface UserFeign {

    //@GetMapping(value = "/client/get/{id}")
    @GetMapping(value = "/server/getUser")
    String getUserInfo(@RequestParam("id") Long id);
}
