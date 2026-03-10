package com.example.Serialization_Deserialization_ApiValidation;


import com.problemfighter.java.oc.copier.ObjectCopier;
import com.problemfighter.pfspring.restapi.rr.RequestProcessor;
import com.problemfighter.pfspring.restapi.rr.ResponseProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProblemFighterConfig {

    @Bean
    public RequestProcessor requestProcessor() {
        return new RequestProcessor();
    }

    @Bean
    public ResponseProcessor responseProcessor() {
        return new ResponseProcessor();
    }

    @Bean
    public ObjectCopier objectCopier() {
        return new ObjectCopier();
    }

}