package com.jvitor.portfolioapi.controller.projects;

import java.util.List;

public record Project(
        String name,
        String description,
        String url,
        String image,
        String urlProject,
        String urlRepository,
        List<Tags> tags
) {}
