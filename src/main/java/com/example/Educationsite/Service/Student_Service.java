package com.example.Educationsite.Service;

import com.example.Educationsite.Model.Student;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface Student_Service {

    public Student savedata(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(int id,Student student);
    public void deleteId(int id);
    public Student update(int id,Student student);

}
