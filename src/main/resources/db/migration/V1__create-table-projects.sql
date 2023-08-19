create TABLE projects (
    id bigint not null primary key auto_increment,
    name varchar(255) not null,
    description varchar(255) null,
    url varchar(255) null,
    image varchar(255) null,
    url_project varchar(255) null,
    url_repository varchar(255) null,
    tags_projects varchar(255) null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE tags (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tag VARCHAR(50) NOT NULL
);

create TABLE projects_tags (
    project_id bigint not null,
    tag_id bigint not null,
    FOREIGN KEY (project_id) REFERENCES projects (id),
    FOREIGN KEY (tag_id) REFERENCES tags (id),
    PRIMARY KEY (project_id, tag_id)
);
