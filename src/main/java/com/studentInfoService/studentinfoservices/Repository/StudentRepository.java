package com.studentInfoService.studentinfoservices.Repository;


import com.studentInfoService.studentinfoservices.Entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {


}
