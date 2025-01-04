package com.tpe.repository;

import com.tpe.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository implements IRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {

        Session session = sessionFactory.openSession();
//        String hqlQuery = "FROM Student";
//        session.createQuery(hqlQuery, Student.class);
        List<Student> allStudents = session.createQuery("FROM Student", Student.class).getResultList();
        session.close();
        return allStudents;
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
