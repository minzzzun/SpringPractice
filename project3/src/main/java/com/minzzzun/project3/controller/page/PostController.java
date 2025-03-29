package com.minzzzun.project3.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/post")
@Controller
public class PostController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        return "post/"+page;
    }
}
