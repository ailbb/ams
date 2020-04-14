package com.ailbb.ams.controller;

import com.ailbb.ajj.$;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Wz on 5/30/2018.
 */
@RestController
public class MappingController {
    @Autowired
    RestTemplate restTemp;

    @Value("${spring.application.name}")
    private String appName;

    // RestTemp方式负载均衡，推荐
//    @HystrixCommand(fallbackMethod = "hiError") // 创建熔断器，请求超时后返回该内容，hiError为一个方法
    @RequestMapping("/rest/*/**")
    public String restTempService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String s = "/";
        List<String> uris = $.list.arrayToList(request.getRequestURI().split(s));
        String url = $.url($.concat(uris.get(2).toUpperCase(), s, $.join(uris.subList(3, uris.size()), s), "?", $.getParameterStr(request)));

        return restTemp.postForObject(
                $.info(String.format("RestTemp To [%s]", url), url),
                $.getRequestBody(request),
                String.class
        );
    }

    @Qualifier("feignAysControllerHiHystric")
    @Autowired
    FeignAysController feignAysController;

    // feign方式负载均衡，不推荐
    @RequestMapping("/feign/*/**")
    public String feignTempService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String s = "/";
        List<String> uris = $.list.arrayToList(request.getRequestURI().split(s));
        if(uris.get(2).equalsIgnoreCase("ays"))
            return feignAysController.getAppIndex(request);
        else
            return feignAysController.getAppIndex(request);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
