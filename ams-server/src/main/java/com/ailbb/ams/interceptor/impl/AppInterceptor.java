package com.ailbb.ams.interceptor.impl;

import com.ailbb.ajj.$;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 所有App信息的接口类
 * Created by Wz on 6/4/2018.
 */
@Component
public class AppInterceptor extends HandlerInterceptorAdapter {

    private String $APP = "app";

    @Value("${spring.application.name}")
    private String appName;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI().substring($APP.length() + 1);

        if($.test(uri, "/") || $.test(uri, "/index")) $.send(response, index(request, response));

        return true;
    }

    @Override
    public String toString(){
        return $APP;
    }

    public String index(HttpServletRequest request, HttpServletResponse response) {
        return String.format("[%s service]\r\n[GET parameter]: %s\r\n[POST parameter]: %s",
                appName,
                $.toJsonString(request.getParameterMap()),
                $.getRequestBody(request)
        );
    }
}
