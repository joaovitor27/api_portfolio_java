package com.jvitor.portfolioapi.controller.projects;

import com.jvitor.portfolioapi.controller.tags.Tag;

public record ProjectList(
        Long id,
        String name,
        String description,
        String url,
        String image,
        String urlProject,
        String urlRepository,
        java.util.Set<Tag> tags) {

    public ProjectList(Project project) {
        this(project.getId(), project.getName(), project.getDescription(), project.getUrl(), project.getImage(),
                project.getUrlProject(), project.getUrlRepository(), project.getTagsProjects()
        );
    }
}
