package com.config.server.dto;

import com.config.server.entity.Property;
import lombok.Data;

@Data
public class PropertyDto {
    private String application;
    private String profile;
    private String label;
    private String key;
    private String value;

    public Property toEntity() {
        return Property.builder()
                .application(getApplication())
                .profile(getProfile())
                .label(getLabel())
                .key(getKey())
                .value(getValue())
                .build();
    }
}
