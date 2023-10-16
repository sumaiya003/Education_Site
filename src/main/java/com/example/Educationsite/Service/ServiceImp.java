package com.example.Educationsite.Service;
import com.example.Educationsite.Model.Student;
import com.example.Educationsite.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Random;
@Component
public class ServiceImp implements Student_Service{
    @Autowired
    StudentRepo repo;
    @Override
    public Student savedata(Student student) {
        return repo.save(student);
    }
    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
    @Override
    public Student getStudentById(int id, Student student) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Invalid Id"));
    }
    @Override
    public void deleteId(int id) {
       repo.deleteById(id);
    }
    @Override
    public Student update(int id,Student student){
        Student st=repo.findById(id).orElseThrow(()-> new RuntimeException("Invalid id"));
        Random random=new Random();
        int Id= random.nextInt(50);
        st.setId(Id);
        repo.save(st);
        return st;
    }
}
