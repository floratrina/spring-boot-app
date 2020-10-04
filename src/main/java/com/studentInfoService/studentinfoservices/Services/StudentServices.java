package com.studentInfoService.studentinfoservices.Services;

import com.studentInfoService.studentinfoservices.Entity.Student;
import com.studentInfoService.studentinfoservices.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    public StudentRepository studentRepository;

    public List<Student> retrieveStudent() {
        List<Student> listOfStudent = (List<Student>)studentRepository.findAll();
        return listOfStudent;
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student update(Student student, Long id) {
        return  studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
