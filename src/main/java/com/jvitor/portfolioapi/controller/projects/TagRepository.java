package com.jvitor.portfolioapi.controller.projects;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    boolean existsByTag(TagsProject tag);

    Tag findByTag(TagsProject tag);
}
