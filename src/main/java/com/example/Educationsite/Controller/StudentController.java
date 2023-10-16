package com.example.Educationsite.Controller;

import com.example.Educationsite.Model.Student;
import com.example.Educationsite.Repo.StudentRepo;
import com.example.Educationsite.Service.Student_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentRepo repo;
    @Autowired
    private Student_Service service;
    Logger logger= LoggerFactory.getLogger(StudentController.class);
    @PostMapping("/students")
    public ResponseEntity<Student> create(@RequestBody Student student){
        logger.info("Data inserted successfully",student);
        Student student1=service.savedata(student);
        return new ResponseEntity<>(student1,HttpStatus.CREATED); 
    }
    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getall(){
        List<Student> list=service.getAllStudents();
        logger.info("Fetched all",list);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id,Student student){
        Student student1=service.getStudentById(id,student);
        logger.info("Fetched by id",student1);
        return new ResponseEntity<>(student1,HttpStatus.OK);
    }
    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<String[]> getCourse(@PathVariable int id,Student student){
       // Student student1=repo.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));
        Student student1=service.getStudentById(id,student);
        String[] courses =student1.getCourses_enrolled();
        logger.info("Fetched Course by id",courses);
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable int id,Student student){
        Student student1=service.update(id,student);
        logger.info("Updated id",student1);
        return new ResponseEntity<>(student1,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> delete(@PathVariable int id,Student student) {
        service.deleteId(id);
        logger.info("Deleted");
        service.savedata(student);
        return new ResponseEntity<>(student, HttpStatus.GONE);
    }
}
