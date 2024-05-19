package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.StudentNotFoundException;
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
        repository.saveOrUpdate(student);
    }

    @Override
    public Student findStudentById(Long id) {
        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("NO Student with ID: " + id));
        return existingStudent;

        //if there's an exception, handle it or return the student
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
