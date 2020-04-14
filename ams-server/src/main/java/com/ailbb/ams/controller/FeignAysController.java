package com.ailbb.ams.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Wz on 9/19/2018.
 */
@FeignClient(value = "ams", fallback = FeignAysControllerHiHystric.class) // 客户端名称
public interface FeignAysController {
    @RequestMapping(value = "/app/index",method = RequestMethod.GET) // 映射及请求
    String getAppIndex(HttpServletRequest request);
}
