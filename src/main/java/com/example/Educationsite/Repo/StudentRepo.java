package com.example.Educationsite.Repo;

import com.example.Educationsite.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
