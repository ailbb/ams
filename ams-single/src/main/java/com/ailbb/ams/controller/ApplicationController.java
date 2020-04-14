package com.ailbb.ams.controller;

import com.ailbb.ajj.$;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Wz on 5/30/2018.
 */
@RestController
@RequestMapping(value = "/app")
public class ApplicationController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = {"/", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return String.format("[%s service]\r\n[GET parameter]: %s\r\n[POST parameter]: %s",
                appName,
                $.toJsonString(request.getParameterMap()),
                $.getRequestBody(request)
        );
    }

    @RequestMapping(value = {"/choose"})
    public ServiceInstance test(@RequestParam String name) {
        return loadBalancerClient.choose(name);
    }
}
