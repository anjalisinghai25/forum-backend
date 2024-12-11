package com.discussion.forum.entities;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Material {


    private String id;

    private Course course;

    private Integer semester;

    private User user;

    private MaterialType type;

    private String fileUrl;
    private String description;

    public enum MaterialType {
        NOTES, QUESTION_PAPER, EXPERIENCE
    }
}

