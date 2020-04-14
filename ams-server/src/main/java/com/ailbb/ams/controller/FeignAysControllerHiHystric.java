package com.ailbb.ams.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Feign 熔断器接口实现类
 * Created by Wz on 9/19/2018.
 */
@Component
public class FeignAysControllerHiHystric implements FeignAysController {
    @Value("${spring.application.name}")
    private String appName;

    @Override
    public String getAppIndex(HttpServletRequest request) {
        return "hi,"+appName+",sorry,error!";
    }
}
