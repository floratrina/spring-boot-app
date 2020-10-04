package com.studentInfoService.studentinfoservices.Rest;

import com.studentInfoService.studentinfoservices.Entity.Student;
import com.studentInfoService.studentinfoservices.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentProfile {

    public StudentServices studentServices;

    @Autowired
    public void setStudentServices(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping(value = "/get-profile", headers = "Accept=application/json")
    public List<Student> getProfile() {
        return studentServices.retrieveStudent();
    }

    @GetMapping(value = "/get-profile/{id}", headers = "Accept=application/json")
    public Optional<Student> getProfileByID(@PathVariable Long id) {
        return studentServices.findById(id);
    }

    @PostMapping(value="/post-profile", headers = "Accept=application/json")
    public ResponseEntity<Void> createProfile(@RequestBody Student student, UriComponentsBuilder uriComponentsBuilder) {
        studentServices.createStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/api/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value="/update-profile", headers = "Accept=application/json")
    public ResponseEntity<String> updateProfile(@RequestBody Student currentStudent) {
        Optional<Student> updatedStudent = studentServices.findById(currentStudent.getId());
        if(updatedStudent==null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        studentServices.update(currentStudent, currentStudent.getId());
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @DeleteMapping(value="/delete-profile/{id}", headers= "Accept=application/json")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        Optional<Student> student = studentServices.findById(id);
        if(student==null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        studentServices.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
