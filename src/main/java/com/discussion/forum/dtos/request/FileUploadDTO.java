package com.discussion.forum.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileUploadDTO {

    private String content;
    private String name;
    private String folder;
    private List<String> tags = new ArrayList<>();


    public void addTags(String... tags) {
        this.tags.addAll(List.of(tags));
    }

}
