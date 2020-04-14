package com.ailbb.ams.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

/**
 * Created by Wz on 6/4/2018.
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    HandlerInterceptor appInterceptor;

    @Autowired
    HandlerInterceptor routeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        // 映射为 user 的控制器下的所有映射
        for(HandlerInterceptor h : Arrays.asList(appInterceptor, routeInterceptor))
//            registry.addInterceptor(h).addPathPatterns($.concat("/", h.toString(), "/**"));

        super.addInterceptors(registry);
    }

}