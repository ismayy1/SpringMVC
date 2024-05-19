package com.tpe.repository;

import com.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public class StudentRepositoryImplementation implements StudentRepository {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void saveOrUpdate(Student student) {

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }
}
