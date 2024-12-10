package com.discussion.forum.controller;

import com.discussion.forum.dtos.BaseResponseDTO;
import com.discussion.forum.dtos.request.FileUploadDTO;
import com.discussion.forum.service.FilesSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FilesSerivce filesSerivce;

    @PostMapping("")
    public ResponseEntity<BaseResponseDTO> uploadFiles(@RequestBody FileUploadDTO uploadDTO) {
        return ResponseEntity.ok(filesSerivce.uploadFile(uploadDTO));
    }


}
