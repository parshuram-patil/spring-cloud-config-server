package com.config.server.controller;

import com.config.server.dto.KeyValue;
import com.config.server.service.EnvironmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.web.bind.annotation.*;

import static com.config.server.constant.Constants.DEFAULT_APPLICATION;
import static com.config.server.constant.Constants.DEFAULT_PROFILE;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class ConfigController {

    private final EnvironmentService environmentService;

    @GetMapping("/{application}/{profile}")
    public Environment getEnvironmentByApplicationAndProfile(@PathVariable String application, @PathVariable String profile) {
        return environmentService.getEnvironment(application, profile);
    }

    @PostMapping
    public String saveProperty(@RequestBody KeyValue keyValue) {
        return environmentService.saveProperty(DEFAULT_APPLICATION, DEFAULT_PROFILE, keyValue);
    }

    @PostMapping("/{application}")
    public String saveProperty(@PathVariable String application, @RequestBody KeyValue keyValue) {
        return environmentService.saveProperty(application, DEFAULT_PROFILE, keyValue);
    }

    @PostMapping("/{application}/{profile}")
    public String saveProperty(@PathVariable String application, @PathVariable String profile, @RequestBody KeyValue keyValue) {
        return environmentService.saveProperty(application, profile, keyValue);
    }
}

