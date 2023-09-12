/*
package com.config.server;

import com.config.server.entity.Property;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentProperties;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EnvironmentConfigRepository extends JdbcEnvironmentRepository {

    private final PropertyRepository propertyRepository;

    public EnvironmentConfigRepository(
            JdbcTemplate jdbc,
            JdbcEnvironmentProperties properties,
            PropertiesResultSetExtractor extractor,
            PropertyRepository propertyRepository
    ) {
        super(jdbc, properties, extractor);
        this.propertyRepository = propertyRepository;
    }

    public Environment saveProperty(Property property) {
        Optional<Property> propertyOptional = propertyRepository.getProperty(
                property.getApplication(), property.getProfile(), property.getLabel(), property.getKey()
        );

        if (propertyOptional.isPresent()) {
            Property propertyToUpdate = propertyOptional.get();
            property.setId(propertyToUpdate.getId());
        }
        propertyRepository.save(property);

        return findOne(property.getApplication(), property.getProfile(), property.getLabel());
    }
}
*/
