package com.example.Serialization_Deserialization_ApiValidation.service;

import com.example.Serialization_Deserialization_ApiValidation.dto.StudentDto;
import com.example.Serialization_Deserialization_ApiValidation.entity.Student;
import com.example.Serialization_Deserialization_ApiValidation.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo repo;

    public StudentDto save(StudentDto dto) {

        Student student = new Student(
                null,
                dto.getName(),
                dto.getDepartment()
        );

        Student saved = repo.save(student);

        return new StudentDto(
                saved.getId(),
                saved.getName(),
                saved.getDepartment()
        );
    }

    public List<StudentDto> findAll() {
        return repo.findAll()
                .stream()
                .map(s -> new StudentDto(s.getId(), s.getName(), s.getDepartment()))
                .toList();
    }
}