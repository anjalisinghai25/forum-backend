package com.discussion.forum.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    private String collageName;

    private Course course;

    private Integer semester;


    public static class Course {

        @Id
        private String id;

        private String name;

        private Integer noOfSemesters;

    }

}

