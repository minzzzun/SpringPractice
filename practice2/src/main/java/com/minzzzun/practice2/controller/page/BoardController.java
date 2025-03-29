package com.minzzzun.practice2.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "board/" + page;
    }


}
