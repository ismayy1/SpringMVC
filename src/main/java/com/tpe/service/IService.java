package com.tpe.service;

import com.tpe.domain.Student;

import java.util.List;

public interface IService {

    List<Student> findAllStudents();

    void saveOrUpdateStudent(Student student);

    Student findStudentById(Long id);

    void deleteStudent(Long id);
}
