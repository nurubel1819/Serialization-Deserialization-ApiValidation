package com.example.Serialization_Deserialization_ApiValidation.controller;

import com.example.Serialization_Deserialization_ApiValidation.service.WhatsAppService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/whatApp")
public class WhatAppController {

    private final WhatsAppService whatsAppService;

    @PostMapping("/test")
    public void WhatAppsTest(
            @RequestParam
            String phone
    ) throws JsonProcessingException {
        String templateId = "e44a327c-c64a-474a-89c8-18c605701693";
        List<String> params = new ArrayList<>();
        params.add("Rubel");
        params.add("Khan");

        whatsAppService.sendTemplateMessage(phone,templateId,params);
    }
}
