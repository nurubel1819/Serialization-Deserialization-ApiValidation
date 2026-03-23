package com.example.Serialization_Deserialization_ApiValidation.service;

import com.example.Serialization_Deserialization_ApiValidation.dto.WhatsAppMessageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WhatsAppService {

    //need configuration for it
    private final RestTemplate restTemplate;

    //@Value("${gupshup.api-url}")
    private String apiUrl = "https://api.gupshup.io/wa/api/v1/template/msg";

    //@Value("${gupshup.api-key}")
    private String apiKey = "sk_e6af383d63894c62802133dfcca2b270";

    //@Value("${gupshup.source}")
    private String source = "919148497777";

    //@Value("${gupshup.src-name}")
    private String srcName = "InvestforWellness";

    public void sendTemplateMessage(String mobile, String templateId, List<String> params) throws JsonProcessingException {

        WhatsAppMessageRequest request = new WhatsAppMessageRequest();
        request.setSource(source);
        request.setDestination(mobile);
        request.setSrcName(srcName);

        WhatsAppMessageRequest.Template template = new WhatsAppMessageRequest.Template();
        template.setId(templateId);
        template.setParams(params);

        request.setTemplate(template);

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", apiKey);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("channel", "whatsapp");
        body.add("source", source);
        body.add("destination", mobile);
        body.add("src.name", srcName);
        body.add("template", new ObjectMapper().writeValueAsString(template));

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);

        // log response
        System.out.println("WhatsApp Response: " + response.getBody());
    }

    public void sendDocumentMessage(String mobile,
                                    String templateId,
                                    List<String> params,
                                    String fileUrl,
                                    String fileName) {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("apikey", apiKey);
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

            body.add("channel", "whatsapp");
            body.add("source", source);
            body.add("destination", mobile);
            body.add("src.name", srcName);

            // Template JSON
            Map<String, Object> template = new HashMap<>();
            template.put("id", templateId);
            template.put("params", params);

            body.add("template", new ObjectMapper().writeValueAsString(template));

            // Document JSON
            Map<String, Object> document = new HashMap<>();
            document.put("link", fileUrl);
            document.put("filename", fileName);

            Map<String, Object> message = new HashMap<>();
            message.put("type", "document");
            message.put("document", document);

            body.add("message", new ObjectMapper().writeValueAsString(message));

            HttpEntity<MultiValueMap<String, String>> entity =
                    new HttpEntity<>(body, headers);

            ResponseEntity<String> response =
                    restTemplate.postForEntity(apiUrl, entity, String.class);

            System.out.println("Response: " + response.getBody());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
