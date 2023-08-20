package com.jvitor.portfolioapi.controller.projects;

import com.jvitor.portfolioapi.controller.tags.Tag;

public record ProjectList(
        String name,
        String description,
        String url,
        String image,
        String urlProject,
        String urlRepository,
        java.util.Set<Tag> tags) {

    public ProjectList(Project project) {
        this(project.getName(), project.getDescription(), project.getUrl(), project.getImage(), project.getUrlProject(),
                project.getUrlRepository(), project.getTagsProjects()
        );
    }
}
