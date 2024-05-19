package com.tpe.service;

import com.tpe.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> listAllStudent();

    void addOrUpdateStudents(Student student);

    Student findStudentById(Long id);

    void deleteStudent(Long id);

}
