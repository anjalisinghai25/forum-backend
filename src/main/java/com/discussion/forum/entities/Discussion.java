package com.discussion.forum.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Discussion {

    @Id
    private String id;

    private User user;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdOn;


    private List<Comment> comments;

    protected void onCreate() {
        createdOn = LocalDateTime.now();
    }

    @Data
    public class Comment {
        @Id
        private String id;
        private User user;

        private String comment;
        @CreatedDate
        private LocalDateTime createdOn;


        @Data
        public static class Users {
            @Id
            private String id;
            private String name;
            private String mobile;
            private String email;
        }

    }

}
