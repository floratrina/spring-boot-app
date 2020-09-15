package com.studentInfoService.studentinfoservices.Rest;

import com.studentInfoService.studentinfoservices.Entity.Student;
import com.studentInfoService.studentinfoservices.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentProfile {

    public StudentServices studentServices;

    @Autowired
    public void setStudentServices(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("/profile")
    public List<Student> getProfile() {
        return studentServices.retrieveStudent();
    }

}
