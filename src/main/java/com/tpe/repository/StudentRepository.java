package com.tpe.repository;

import com.tpe.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

//    2B
    @Override
    public void saveOrUpdate(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(student);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(student);

        transaction.commit();
        session.close();
    }

    @Override
    public Optional<Student> findById(Long id) {
        Session session = sessionFactory.openSession();
        Student foundStudent = session.get(Student.class, id);
        Optional<Student> optionalStudent = Optional.ofNullable(foundStudent);

        session.close();
        return optionalStudent;
    }
}
