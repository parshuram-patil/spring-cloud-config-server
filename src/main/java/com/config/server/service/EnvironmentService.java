package com.config.server.service;

import com.config.server.PropertyRepository;
import com.config.server.dto.KeyValue;
import com.config.server.entity.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static com.config.server.constant.Constants.DEFAULT_LABEL;

@Service
@RequiredArgsConstructor
public class EnvironmentService {

    @Value("${client.server.url}")
    private String clientServerUrl;

    private final JdbcEnvironmentRepository environmentRepository;
    private final PropertyRepository propertyRepository;
    private final RestTemplate restTemplate;

    public String saveProperty(String application, String profile, KeyValue keyValue) {
        Property property = Property.builder()
                .application(application)
                .profile(profile)
                .label(DEFAULT_LABEL)
                .key(keyValue.getKey())
                .value(keyValue.getValue())
                .build();
        Optional<Property> propertyOptional = propertyRepository.getProperty(
                property.getApplication(), property.getProfile(), property.getLabel(), property.getKey()
        );

        if (propertyOptional.isPresent()) {
            Property propertyToUpdate = propertyOptional.get();
            property.setId(propertyToUpdate.getId());
        }
        propertyRepository.save(property);
        refreshClientConfigurations();
        return keyValue.getKey();
    }

    public Environment getEnvironment(String application, String profile) {
        return environmentRepository.findOne(application, profile, DEFAULT_LABEL);
    }

    private void refreshClientConfigurations() {
        restTemplate.postForEntity(clientServerUrl, null, List.class);
    }
}
