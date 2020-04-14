package com.ailbb.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wz on 9/19/2018.
 */
@RestController
@RefreshScope
@RequestMapping(value = "/config")
public class ConfigController {
    @Value("${cluster.host}")
    String host;

    @Value("${cluster.host}")
    String host1;



    @Autowired
    private Environment env;

    @RequestMapping(value = "/getkey")
    public String foo(String key){
        env.getProperty("cluster.host");

        if(null == key || String.valueOf(key).equalsIgnoreCase("")) return String.valueOf(host);
        return env.getProperty(key);
    }
}
