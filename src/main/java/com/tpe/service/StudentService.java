package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // specialized component
public class StudentService implements IService {

    @Autowired
    private IRepository repository;


    public List<Student> findAllStudents() {
        return repository.findAll();
    }

//    2B
    @Override
    public void saveOrUpdateStudent(Student student) {
        repository.saveOrUpdate(student);
    }

    @Override
    public Student findStudentById(Long id) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
