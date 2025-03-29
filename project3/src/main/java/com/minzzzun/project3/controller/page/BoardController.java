package com.minzzzun.project3.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/board")
@Controller
public class BoardController {
    @RequestMapping("/{page}")
    public String board(@PathVariable String page) {  // @PathVariable 이름 같아서 축약형으로 표현
        return "board/" + page;
    }

}
