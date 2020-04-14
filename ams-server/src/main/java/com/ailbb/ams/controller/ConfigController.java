package com.ailbb.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wz on 9/19/2018.
 */
@RestController
@RequestMapping(value = "/config")
public class ConfigController {
    @Autowired
    private Environment env;

    @RequestMapping(value = "/getkey")
    public String foo(String key){
        return env.getProperty(key);
    }
}
