package com.ailbb.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @RequestMapping(value = {"/", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
