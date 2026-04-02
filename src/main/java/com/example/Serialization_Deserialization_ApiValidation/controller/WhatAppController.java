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

    @PostMapping("/with-document")
    public void WhatAppsTestWithDocument(@RequestParam String phone) throws JsonProcessingException {
        String templateId = "eba507c6-778e-4171-889c-ad295a25df36";
        List<String> params = new ArrayList<>();
        params.add("Rubel");
        params.add("Khan");

        //String fileUrl="https://fss.gupshup.io/0/public/0/0/gupshup/919148497777/97de9ae7-692b-483d-830b-603a5a51026c/1765347368708_lokesh_derangula_screening_report.pdf";
        String fileUrl="https://core-dev.cmedhealth.com/prescription/4301137_25028_1775128131809.pdf?now=1775128133294"; // this is my dev url
        String fileName = "Sample document";

        whatsAppService.sendDocumentMessage(phone,templateId,params,fileUrl,fileName);
    }
}
