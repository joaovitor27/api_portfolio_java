package com.jvitor.portfolioapi.controller.projects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public record ProjectCreate(
        @NotNull
        @NotBlank
        String name,

        String description,
        @URL
        String url,
        String image,
        @URL
        String urlProject,
        @URL
        String urlRepository,
        @Valid
        List<String> tags
) {
}
