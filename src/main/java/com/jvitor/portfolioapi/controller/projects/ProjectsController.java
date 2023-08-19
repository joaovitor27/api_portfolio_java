package com.jvitor.portfolioapi.controller.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TagRepository tagRepository;

    @PostMapping
    @Transactional
    public void createProject(@RequestBody ProjectCreate project) {
        Project projectC = new Project(project);
        project.tags().forEach(tag -> {
            Tag tagC = new Tag();
            tagC.setTag(tag);
            if (!tagRepository.existsByTag(tag)) {
                tagRepository.save(tagC);
            }
            tagC = tagRepository.findByTag(tag);
            projectC.getTagsProjects().add(tagC);
        });
        projectRepository.save(projectC);
    }
}
