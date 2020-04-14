package com.ailbb.ams.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * RestFul Demo
 */
@RestController
public class AilbbController {

    @GetMapping(value = "/hello/{str}")
    public ResponseEntity<List<String>> sayHello(@PathVariable("str") String str) {
        if(str != null)
            return ResponseEntity.ok(Arrays.asList(str));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping(value = "/hi/{str}")
    public ResponseEntity<List<String>> sayHi(@PathVariable("str") String str) {
        if(str != null)
            return ResponseEntity.ok(Arrays.asList(str));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "/say/{method}/{str}")
    public ResponseEntity<List<String>> say(@PathVariable("method") String method, @PathVariable("str") String str) {
        if("hello".equals(method)) {
            return sayHello(str);
        } else if("hi".equals(method)) {
            return sayHi(str);
        } else {
            return ResponseEntity.ok(Arrays.asList("I don't know."));
        }
    }

}

