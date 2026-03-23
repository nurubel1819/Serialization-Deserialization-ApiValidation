package com.example.Serialization_Deserialization_ApiValidation.dto;

import lombok.Data;

import java.util.List;

@Data
public class WhatsAppMessageRequest {

    private String channel = "whatsapp";
    private String source;
    private String destination;
    private String srcName;
    private Template template;

    @Data
    public static class Template {
        private String id;
        private List<String> params;
    }
}
