package com.minzzzun.noticepractice.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface PostService {
    Map<String, Object>  create(Map<String, Object> param);




}
