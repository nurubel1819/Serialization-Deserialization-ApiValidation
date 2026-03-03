package com.example.Serialization_Deserialization_ApiValidation.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class AgeSerializer extends JsonSerializer<Integer> {

    @Override
    public void serialize(Integer value,
                          JsonGenerator gen,
                          SerializerProvider serializers)
            throws IOException {

        // Custom logic
        gen.writeString(value + " years");
    }
}

