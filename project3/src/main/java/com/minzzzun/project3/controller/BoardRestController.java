package com.minzzzun.project3.controller;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    // 리스트 생성
    List<Map<String,Object>> list = new ArrayList<>();

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam String title, @RequestParam String content){
        System.out.println("title : " + title + ", content : " + content);
        int resultCode = 0;

        int order = list.size() +1 ; // 처음 만들때 0번째가 아니고 1번째서 시작하고 싶기 때문

        Map<String, Object> board = new HashMap<>();
        board.put("order", order);
        board.put("title", title);
        board.put("content", content);

        list.add(board);
        System.out.println("list : " + list.size());
        resultCode = 200;

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        resultMap.put("order", order);
        return resultMap;
    }

    @GetMapping("/update/{order}")
    public Map<String, Object> update(@PathVariable("order") int order,
                                      @RequestParam Map<String, Object> param){
        int resultCode = 0;
        resultCode = 200;

        Map<String, Object> board = list.get(order-1);
        Object tempOrder = board.get("order");
        if(tempOrder == null){
            // 이미 지워진 글인 경우
            return null;
        }

        String title = (String) param.get("title");
        if(title != null){
            board.put("title", title);
        }

        String content = (String) param.get("content");
        if(content != null){
            board.put("content", content);
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        return resultMap;
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam int order){
        int resultCode = 0;
        resultCode = 200;

        Map<String, Object> board = list.get(order-1);
        board.remove("order");
        board.remove("title");
        board.remove("content");

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        return resultMap;
    }




    @GetMapping("/list")
    public Map<String, Object> list(){
        int resultCode = 0;
        resultCode = 200;

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        resultMap.put("data", list);
        return resultMap;
    }

    @GetMapping("/detail/{order}")
    public Map<String, Object> detail(@PathVariable("order") int order) {  // @PathVariable("order")라고 명시적 지정
        int resultCode = 0;
        resultCode = 200;

        Map<String, Object> board = list.get(order-1);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        resultMap.put("data", board);
        return resultMap;
    }

 }
