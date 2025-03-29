package com.minzzzun.practice1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    @RequestMapping("/index")
    @ResponseBody
    public String  index(){
        return "index";
    }

    @RequestMapping("/sum")
    public String  sum(@RequestParam int a,@RequestParam  int b, String name, Model model){
        System.out.println("a :" + a);
        System.out.println("b :"+ b);
        System.out.println("name :" + name);
        int sum = a + b;

        System.out.println("sum: " + sum);

        model.addAttribute("sum", sum);
        model.addAttribute("name", name);
        return "sum";
    }

}
