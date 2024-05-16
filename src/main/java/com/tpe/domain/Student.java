package com.tpe.domain;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "t_student")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String firstName;   // first-name => default name

    private String lastName;

    private int grade;

    private LocalDateTime createDate = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

//    public void setCreateDate(LocalDateTime createDate) {
//        this.createDate = createDate;
//    }

}
