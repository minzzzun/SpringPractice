package com.minzzzun.noticepractice.service.impl;

import com.minzzzun.noticepractice.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    List<Map<String, Object>> list = new ArrayList<>();


    @Override
    public Map<String, Object> create(Map<String, Object> param) {
        int order = list.size() + 1;
        Map<String, Object> board = new HashMap<>();
        board.put("order", order);
        board.put("title", param.get("title"));
        board.put("content", param.get("content"));
        list.add(board);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("order", order);
        return resultMap;
    }
}
