package com.jvitor.portfolioapi.controller.projects;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    @PostMapping
    public void createProject(@RequestBody Project project) {
        System.out.println(project);
    }
}
