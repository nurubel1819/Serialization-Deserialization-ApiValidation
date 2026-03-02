package com.example.Serialization_Deserialization_ApiValidation.repo;

import com.example.Serialization_Deserialization_ApiValidation.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
