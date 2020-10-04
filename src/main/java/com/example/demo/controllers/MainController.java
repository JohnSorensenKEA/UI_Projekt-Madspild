package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MainController {

    private String answer = null;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/forbruger")
    public String forbruger(Model calcResult){
        String ans = answer;
        answer = null;
        calcResult.addAttribute("answer",ans);
        return "forbruger";
    }

    @GetMapping("/virksomhed")
    public String virksomhed(){
        return "virksomhed";
    }

    @GetMapping("/organisationer")
    public String organisationer(){
        return "organisationer";
    }

    @PostMapping("/post")
    public String calculator(WebRequest dataForm){
        answer = dataForm.getParameter("faktor");
        return "redirect:/forbruger";
    }
}
