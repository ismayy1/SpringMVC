package com.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // we tell spring from our client can be received by this class.
@RequestMapping("/students") // http://localhost:8080/SpringMvc/students/**
// Class level: Valid for all the controller methods
// Method level: Valid for only method below it
public class StudentController {

    //http://localhost:8080/SpringMvc/students/hi + GET Method
    @GetMapping("/hi")
    public ModelAndView seyHi() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hi,");
        modelAndView.addObject("messageBody", "I am a dynamic web Page.");
        modelAndView.setViewName("hi");

        return modelAndView;
    }
}
