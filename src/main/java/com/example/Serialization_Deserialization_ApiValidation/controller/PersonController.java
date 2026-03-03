package com.example.Serialization_Deserialization_ApiValidation.controller;

import com.example.Serialization_Deserialization_ApiValidation.dto.PersonDot;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    @PostMapping("/new")
    public PersonDot createNewPerson(@RequestBody PersonDot dto) {
        return dto;
    }

    @PostMapping("/object-mapper")
    public String createObjectMapper(@RequestBody PersonDot dto) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(dto);
        return json;
    }






}
