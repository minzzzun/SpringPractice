package com.minzzzun.project3.controller;


import com.minzzzun.project3.service.NoticeService;
import com.minzzzun.project3.service.impl.NoticeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/notice")
public class NoticeRestController {

    // 생성자 방식
    final NoticeService noticeService;
    NoticeRestController(NoticeService noticeService){
        this.noticeService = noticeService;
    }

    @GetMapping("/create")
    public int create(@RequestParam String title, String content, @RequestParam String author){
        int resultCode = noticeService.create(title, content,author);
        return resultCode;
    }
    @GetMapping("/list")
    public List<Map<String, Object>> list(String title, String author){
        List<Map<String, Object>> resultData = noticeService.list(title,author);
        return resultData;
    }
}
