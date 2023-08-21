package com.jvitor.portfolioapi.controller.projects;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ProjectUpdate(
        @NotBlank
        String name,
        String description,
        String url,
        List<String> tags) {

}
