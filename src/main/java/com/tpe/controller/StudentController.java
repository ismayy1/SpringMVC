package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    @GetMapping // http://localhost:8080/springMvc/students/ + GET
    public ModelAndView getStudents () {

        List<Student> allStudent = service.listAllStudent();

        ModelAndView mav = new ModelAndView();
        mav.addObject("studentList", allStudent);
        mav.setViewName("students");

        return mav;
    }

    // method to display studentForm page
    @GetMapping ("/new") // http://localhost:8080/springMvc/students/new + GET
    public String displayForm (@ModelAttribute("student") Student student) {
        return "studentForm";
    }

    // method to post student to DB
    @PostMapping ("/saveStudent") // http://localhost:8080/springMvc/students/saveStudent + POST
    public String saveStudent (@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "studentForm";
        }

        service.addOrUpdateStudents(student);
        return "redirect:/students";    // redirects user to this endPoint http://localhost:8080/springMvc/students
    }

    @GetMapping ("/update") // http://localhost:8080/springMvc/students/update?id=1 + GET
    public ModelAndView displayFormPageToUpdate (@RequestParam ("id") Long id) {
        Student student = service.findStudentById(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("student", student);
        mav.setViewName("studentForm");
        return mav;
    }

}
