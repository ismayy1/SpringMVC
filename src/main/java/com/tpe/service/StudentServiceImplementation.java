package com.tpe.service;

import com.tpe.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service    // @Service already has @Component
public class StudentServiceImplementation implements StudentService {
    @Override
    public List<Student> listAllStudent() {
        return null;
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
