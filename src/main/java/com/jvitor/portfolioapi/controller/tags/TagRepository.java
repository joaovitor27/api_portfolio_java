package com.jvitor.portfolioapi.controller.tags;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    boolean existsByTag(String tag);
    Tag findByTag(String tag);
}
