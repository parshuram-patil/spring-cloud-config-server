package com.config.server.service;

//import com.config.server.EnvironmentConfigRepository;
import com.config.server.PropertyRepository;
import com.config.server.dto.KeyValue;
import com.config.server.entity.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.config.server.constant.Constants.DEFAULT_LABEL;

@Service
@RequiredArgsConstructor
public class EnvironmentService {

    private final JdbcEnvironmentRepository environmentRepository;
    private final PropertyRepository propertyRepository;

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

        return keyValue.getKey();
    }

    public Environment getEnvironment(String application, String profile) {
        return environmentRepository.findOne(application, profile, DEFAULT_LABEL);
    }
}
