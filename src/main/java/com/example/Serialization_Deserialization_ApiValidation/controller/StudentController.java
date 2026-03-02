package com.example.Serialization_Deserialization_ApiValidation.controller;

import com.example.Serialization_Deserialization_ApiValidation.service.StudentFileService;
import com.example.Serialization_Deserialization_ApiValidation.service.StudentService;
import com.example.Serialization_Deserialization_ApiValidation.dto.StudentDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;
    private final StudentFileService studentFileService;

    // Save Student
    @PostMapping
    public StudentDto create(@RequestBody StudentDto dto, HttpSession session) {

        StudentDto saved = service.save(dto);

        // Keep dto in session (Serialization Trigger)
        session.setAttribute("lastStudent", saved);

        return saved;
    }

    // Get All Students
    @GetMapping
    public List<StudentDto> getAll() {
        return service.findAll();
    }

    // Get Last Student From Session
    @GetMapping("/last")
    public Object getLastStudent(HttpSession session) {

        Object obj = session.getAttribute("lastStudent");

        return obj != null ? obj : "No student in session";
    }

    @PostMapping("/serialization/Object→File")
    public String serializationObject(@RequestBody StudentDto dto) throws IOException {
        return studentFileService.saveStudent(dto);
    }

    @GetMapping("deserialization-File→Object")
    public StudentDto deserializationObject() throws IOException, ClassNotFoundException {
        return studentFileService.readStudent();
    }
}
