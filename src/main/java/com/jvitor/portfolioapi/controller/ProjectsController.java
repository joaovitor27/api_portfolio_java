package com.jvitor.portfolioapi.controller;

import com.jvitor.portfolioapi.controller.projects.Project;
import com.jvitor.portfolioapi.controller.projects.ProjectCreate;
import com.jvitor.portfolioapi.controller.projects.ProjectList;
import com.jvitor.portfolioapi.controller.projects.ProjectRepository;
import com.jvitor.portfolioapi.controller.tags.Tag;
import com.jvitor.portfolioapi.controller.tags.TagRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TagRepository tagRepository;

    @PostMapping
    @Transactional
    public void createProject(@RequestBody @Valid ProjectCreate project) {
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

    @GetMapping
    public Page<ProjectList> listProjects(@PageableDefault(size = 20, sort = "name") Pageable pageable) {
        return projectRepository.findAll(pageable).map(ProjectList::new);
    }
}
