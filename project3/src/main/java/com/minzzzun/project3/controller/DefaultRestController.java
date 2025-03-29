package com.minzzzun.project3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DefaultRestController {

    @GetMapping("/test")
    public Map<String,Object> test() {
        Map<String,Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("data","hahaha");

        return map;
    }


    @GetMapping("/mutilple")
    public Map<String, Object > mutilple(int a, int b){
        Map<String, Object > resultMap = new HashMap<>();
        int result = a * b;
        resultMap.put("result", result);

        return resultMap;
    }
}
