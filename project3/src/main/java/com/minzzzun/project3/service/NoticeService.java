package com.minzzzun.project3.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface NoticeService {
     int create(String title, String content, String author);

     List<Map<String, Object>> list(String title, String author );
}
