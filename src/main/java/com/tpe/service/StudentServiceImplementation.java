package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service    // @Service already has @Component
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository repository;
    @Override
    public List<Student> listAllStudent() {
        return repository.findAll();
    }

    @Override
    public void addOrUpdateStudents(Student student) {

    }

    @Override
    public Student findStudentById(Long id) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
