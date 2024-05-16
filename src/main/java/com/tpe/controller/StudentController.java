package com.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // special component to handle requests
@RequestMapping ("/students") // http://localhost:8080/springMvc/students  => end point should be directed to this requestMapping
// we can only use @RequestMapping in class level. if it's used in class level, it's valid for all methods
// we can only use @RequestMapping in method level, then the path will be valid for method only
public class StudentController {

    public ModelAndView sayHi () {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hello");
        mav.addObject("messagebody", "I am a Student Management System");
        mav.setViewName("hi");
        return mav;
    }

}
