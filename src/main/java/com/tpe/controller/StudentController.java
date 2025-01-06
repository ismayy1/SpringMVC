package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.IService;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

//    2 A. Save a Student - Send The Form
    //http://localhost:8080/SpringMvc/students/new + GET request
    @GetMapping("/new")
    public String displayForm(@ModelAttribute("student") Student student) {
        return "studentForm";
    }


//    2 B. Actually Save a Student
    //http://localhost:8080/SpringMvc/students/saveStudent + POST request
    @PostMapping("/saveStudent")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "studentForm";
        }

        service.saveOrUpdateStudent(student);
        return "redirect:/students";
    }

//    3 - Update an Existing Student
    //http://localhost:8080/SpringMvc/students/update?id=1 + GET request
    @GetMapping("/update")
    public ModelAndView displayFormForUpdate(@RequestParam("id") Long id) {   // ("id") here is redundant. If there is only 1 query parameter, it will automatically get that. //The names of the object in the parameter, and the key in the query parameter doesn't have to match. We could say "Long identification" for example.

    }


//    4 - Delete an Existing Student
    //http://localhost:8080/SpringMvc/students/delete/1 + POST request


}
