package com.example.Serialization_Deserialization_ApiValidation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;

    // CREATE API
    @PostMapping
    public ResponseEntity<Patient> createPatient(
            @Valid @RequestBody PatientDto dto) {

        Patient saved = service.save(dto);
        return ResponseEntity.ok(saved);
    }

    // GET API
    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
