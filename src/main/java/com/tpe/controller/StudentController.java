package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.IService;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller // we tell spring from our client can be received by this class.
@RequestMapping("/students") // http://localhost:8080/SpringMvc/students/**
// Class level: Valid for all the controller methods
// Method level: Valid for only method below it
public class StudentController {


    private IService service;

    @Autowired  // Constructor Injectin
    //If there is a constructor with a single parameter, the @Autowired annotation becomes optional. Spring will
    //understand that this constructor is being used for dependency injection.
    public StudentController(IService service) {
        this.service = service;
    }

    //http://localhost:8080/SpringMvc/students/hi + GET request
    @GetMapping("/hi")
    public ModelAndView seyHi() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hi,");
        modelAndView.addObject("messageBody", "I am a dynamic web Page.");
        modelAndView.setViewName("hi");

        return modelAndView;
    }

//    1. List all students
    //http://localhost:8080/SpringMvc/students + GET request
    @GetMapping
    public ModelAndView getStudents() {

        List<Student> studentList = service.findAllStudents();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList", studentList);
        modelAndView.setViewName("students");

        return modelAndView;
    }

//    2. Save a Student
    //http://localhost:8080/SpringMvc/students + GET request
    @GetMapping("/new")
    public String displayForm(@ModelAttribute("student") Student student) {
        return "studentForm";
    }
}
