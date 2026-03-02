package com.example.Serialization_Deserialization_ApiValidation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    public Patient save(PatientDto dto) {

        // Deserialization Already Done by Spring (JSON → DTO)

        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setMobile(dto.getMobile());
        patient.setRegistrationDate(LocalDate.now());

        return repository.save(patient);
    }

    public List<Patient> findAll() {
        return repository.findAll();
    }
}
