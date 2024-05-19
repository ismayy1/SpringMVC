package com.tpe.repository;

import com.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> findAll();

    void saveOrUpdate(Student student);

    void delete(Student student);

    Optional<Student> findById(Long id);    // to avoid NullPointerException we need to use Optional class
                                            // Optional returns empty optional object
                                            // it forces us to check if it has student object using some condition
                                            // if no object, we can handle it by exception

}
