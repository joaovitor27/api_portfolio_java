package com.jvitor.portfolioapi.controller.projects;

import com.jvitor.portfolioapi.controller.tags.Tag;
import com.jvitor.portfolioapi.controller.tags.TagRepository;
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
    @Column(columnDefinition = "boolean default true")
    private Boolean active;

    public Project(ProjectCreate project) {
        this.active = true;
        this.name = project.name();
        this.description = project.description();
        this.url = project.url();
        this.image = project.image();
        this.urlProject = project.urlProject();
        this.urlRepository = project.urlRepository();
        this.tagsProjects = new HashSet<>();
    }

    public Project update(ProjectUpdate project, TagRepository tagRepository) {
        if (project.name() != null) {
            this.name = project.name();
        }
        if (project.description() != null) {
            this.description = project.description();
        }
        if (project.url() != null) {
            this.url = project.url();
        }
        if (project.tags() != null) {
            this.tagsProjects.clear();
            project.tags().forEach(tag -> {
                Tag tagObject = new Tag();
                tagObject.setTag(tag);
                if (!tagRepository.existsByTag(tag)) {
                    tagRepository.save(tagObject);
                }
                tagObject = tagRepository.findByTag(tag);
                this.tagsProjects.add(tagObject);
            });
        }
        return this;
    }

    public void deactivate() {
        this.active = false;
    }
}
