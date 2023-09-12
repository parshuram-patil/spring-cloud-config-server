package com.config.server;

import com.config.server.entity.Property;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PropertyRepository extends CrudRepository<Property, Integer> {

    String DEFAULT_SQL = "SELECT * FROM PROPERTIES WHERE [APPLICATION]=:application AND [PROFILE]=:profile AND [LABEL]=:label AND [KEY]=:key";

    @Query(DEFAULT_SQL)
    Optional<Property> getProperty(String application, String profile, String label, String key);
}
