package com.distance.finder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @GetMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
         modelAndView.setViewName("react/build/index.html");
         return modelAndView;
    }
}
