package com.rasyidcode.spring_pc_builds.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ComponentSpecUtils {

    private final ObjectMapper objectMapper;

    public ComponentSpecUtils(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T extends Spec> Optional<T> convertToSpecObject(String specs, Class<T> specClass) {
        try {
            return Optional.of(objectMapper.readValue(specs, specClass));
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }

}
