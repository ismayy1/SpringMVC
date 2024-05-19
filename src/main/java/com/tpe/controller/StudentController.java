package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller // special component to handle requests
@RequestMapping ("/students") // http://localhost:8080/springMvc/students  => end point should be directed to this requestMapping
// we can only use @RequestMapping in class level. if it's used in class level, it's valid for all methods
// we can only use @RequestMapping in method level, then the path will be valid for method only
public class StudentController {

    @Autowired
    private StudentService service;

    // http://localhost:8080/springMvc/students/hi + GET  => end point
    @GetMapping ("/hi") // HTTP method type
    public ModelAndView sayHi () {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hello");
        mav.addObject("messagebody", "I am a Student Management System");
        mav.setViewName("hi");
        return mav;
    }

    // end point to return all students
    @GetMapping ("")    // http://localhost:8080/springMvc/students/ + GET
    public ModelAndView getStudents () {

        List<Student> allStudent = service.listAllStudent();

        return null;
    }

}
