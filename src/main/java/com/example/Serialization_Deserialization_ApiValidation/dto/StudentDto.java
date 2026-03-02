package com.example.Serialization_Deserialization_ApiValidation.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String department;
}
