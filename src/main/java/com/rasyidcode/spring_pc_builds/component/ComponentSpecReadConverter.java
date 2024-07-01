package com.rasyidcode.spring_pc_builds.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class ComponentSpecReadConverter implements Converter<String, Spec> {

    private final ObjectMapper objectMapper;

    public ComponentSpecReadConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Spec convert(String source) {
        try {
            return objectMapper.readValue(source, Spec.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
