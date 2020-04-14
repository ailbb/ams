package com.ailbb.ams.interceptor.impl;

import com.ailbb.ajj.$;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义实现转发及动态路由的实现类
 * Created by Wz on 6/4/2018.
 */
@Component
public class RouteInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    public RestTemplate restTemp;

    @Value("${service.ams.name}")
    private String serviceName;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI().substring(serviceName.length() + 1), s = "/";

        if($.isEmptyOrNull(uri.replaceAll(s, "")))
            $.redirect(response, s);
        else
            $.send(response, restTemp.postForObject(
                    $.url($.concat(uri, "?", $.getParameterStr(request.getParameterMap()) )),
                    $.getRequestBody(request),
                    String.class
            ));

        return true;
    }

    @Override
    public String toString() {
        return serviceName = $.isEmptyOrNull(serviceName) ? $.$NAME : serviceName;
    }
}
