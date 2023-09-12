package com.config.server.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("PROPERTIES")
public class Property {
    @Id
    private Integer id;
    private String application;
    private String profile;
    private String label;
    private String key;
    private String value;
}