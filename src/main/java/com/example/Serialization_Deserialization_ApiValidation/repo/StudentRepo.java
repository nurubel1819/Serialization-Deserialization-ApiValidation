package com.example.Serialization_Deserialization_ApiValidation.repo;


import com.example.Serialization_Deserialization_ApiValidation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
