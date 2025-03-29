package com.minzzzun.project3.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/notice")
@Controller
public class NoticeController {

//    @GetMapping("/create") // GET 방식으로만 가능함
//    public String create(){
//        return "create";
//    }
//
//    @GetMapping("/update")
//    public String update(){
//        return "update";
//    }
//
    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "notice/" + page ;
    }
    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "notice/" + page ;
    }

}
