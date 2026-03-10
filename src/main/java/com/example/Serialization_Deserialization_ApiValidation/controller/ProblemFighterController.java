package com.example.Serialization_Deserialization_ApiValidation.controller;

import com.example.Serialization_Deserialization_ApiValidation.dto.PFTestDto;

import com.example.Serialization_Deserialization_ApiValidation.entity.PFTest;
import com.problemfighter.pfspring.restapi.rr.RequestProcessor;
import com.problemfighter.pfspring.restapi.rr.ResponseProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/problem-fighter")
@RequiredArgsConstructor
public class ProblemFighterController {

    private final RequestProcessor requestProcessor;
    private final ResponseProcessor responseProcessor;

    @PostMapping("/test/first")
    public PFTest testFirst(@RequestBody PFTestDto dto) {

        return requestProcessor.process(dto, PFTest.class);
    }
}
