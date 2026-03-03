package com.example.Serialization_Deserialization_ApiValidation.dto;

import com.example.Serialization_Deserialization_ApiValidation.serializer.AgeSerializer;
import com.example.Serialization_Deserialization_ApiValidation.serializer.CustomDateDeserializer;
import com.example.Serialization_Deserialization_ApiValidation.serializer.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDot {

    @JsonProperty("full_name")
    private String name;
    @JsonSerialize(using = AgeSerializer.class)
    private int age;
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private LocalDateTime birthDate;
}
