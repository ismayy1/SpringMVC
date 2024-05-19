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
public class StudentRepositoryImplementation implements StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.openSession();

        String query = "FROM Student";
        List<Student> allStudents = session.createQuery(query, Student.class).getResultList();
        session.close();
        return allStudents;
    }

    @Override
    public void saveOrUpdate(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Insert info
        session.saveOrUpdate(student);  // saveOrUpdate(): if student exists, it'll update, else inserts new students

        tx.commit();
        session.close();
    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public Optional<Student> findById(Long id) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        Optional<Student> optionalStudent = Optional.ofNullable(student);
        session.close();
        return optionalStudent;
    }
}
