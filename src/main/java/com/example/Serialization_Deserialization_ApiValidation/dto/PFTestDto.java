package com.example.Serialization_Deserialization_ApiValidation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PFTestDto {
    private String name;
    private Integer age;
    private String mobile;
    private LocalDate registrationDate;
}
