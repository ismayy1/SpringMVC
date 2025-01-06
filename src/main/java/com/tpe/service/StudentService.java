package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.StudentNotFoundException;
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
//        Student foundStudent = repository.findById(id).get();
        Student foundStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found With ID:" + id));
//                If the optional returnedactually has a student inside, returns the student, assigns it.
//                If not, if the Optional is Empty, we can throw an exception of our choice using orElseThrow.
        return foundStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        Student foundStudent = findStudentById(id);
        repository.delete(foundStudent);
    }
}
