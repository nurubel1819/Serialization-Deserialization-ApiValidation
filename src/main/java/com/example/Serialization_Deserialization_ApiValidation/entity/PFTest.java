package com.example.Serialization_Deserialization_ApiValidation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "problem_fighter_test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PFTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String mobile;
    private LocalDate registrationDate;
}
