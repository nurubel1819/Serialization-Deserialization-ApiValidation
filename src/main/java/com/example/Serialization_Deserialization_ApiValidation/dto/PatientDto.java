package com.example.Serialization_Deserialization_ApiValidation.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    @NotBlank(message = "Patient name is required")
    @Size(min = 3, max = 100)
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 150, message = "Invalid age")
    private Integer age;

    @NotBlank(message = "Mobile number required")
    @Pattern(regexp = "^(01)[0-9]{9}$", message = "Invalid Bangladesh mobile number")
    private String mobile;
}
