package com.studentInfoService.studentinfoservices.Services;

import com.studentInfoService.studentinfoservices.Entity.Student;
import com.studentInfoService.studentinfoservices.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {

    @Autowired
    public StudentRepository studentRepository;

    public List<Student> retrieveStudent() {
        List<Student> listOfStudent = (List<Student>)studentRepository.findAll();
        return listOfStudent;
    }
}
