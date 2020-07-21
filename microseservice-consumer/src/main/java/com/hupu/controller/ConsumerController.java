package com.hupu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private static final String REST_URL_PREFIX = "http://MICROSERVICE-PROVIDER-USER";

    /**
     * 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/user/{id}")
    String getUserInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/server/getUser/" + id, String.class);
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/user/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/server/discovery", Object.class);
    }
}
