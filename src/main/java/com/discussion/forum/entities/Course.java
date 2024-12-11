package com.discussion.forum.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Course {

    @Id
    private String id;

    private String name;

    private Integer noOfSemesters;

 }
