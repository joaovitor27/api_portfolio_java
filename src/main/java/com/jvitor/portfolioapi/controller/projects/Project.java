package com.jvitor.portfolioapi.controller.projects;

import com.jvitor.portfolioapi.controller.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Table(name = "projects")
@Entity(name = "Project")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String url;
    private String image;
    private String urlProject;
    private String urlRepository;
    @ManyToMany
    @JoinTable(name = "projects_tags",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tagsProjects;
    private String teste;

    public Project(ProjectCreate project) {
        this.name = project.name();
        this.description = project.description();
        this.url = project.url();
        this.image = project.image();
        this.urlProject = project.urlProject();
        this.urlRepository = project.urlRepository();
        this.tagsProjects = new HashSet<>();
    }
}
