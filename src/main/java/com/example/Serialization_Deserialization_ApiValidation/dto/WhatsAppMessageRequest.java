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

    @Data
    public static class Message {
        private String type;
        private Document document;
    }

    @Data
    public static class Document {
        private String link;
        private String filename;
    }
}
