package com.studentInfoService.studentinfoservices.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student", schema="university")
public class Student {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String dob;

    public Student(Long id, String name, String dob) {
        Id = id;
        this.name = name;
        this.dob = dob;
    }

    public Student() {}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}
