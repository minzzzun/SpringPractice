package com.minzzzun.practice2.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
//
//    @RequestMapping("/{page}")
//    public String page(@PathVariable String page) {
//        return page;
//    }

    @RequestMapping("/sum")
    @ResponseBody
    public String  sum(@RequestParam int a, @RequestParam int b, String name, Model model) {
        System.out.println("a: "+ a);
        System.out.println("b: " + b);
        int sum = a + b;
        System.out.println("sum: " + sum);
        System.out.println("name: " + name);
        model.addAttribute("sum",sum);
        model.addAttribute("name",name);

        return "sum";
    }



}
