package com.discussion.forum.service;

import com.discussion.forum.dtos.BaseResponseDTO;
import com.discussion.forum.dtos.request.FileUploadDTO;
import com.discussion.forum.utils.ImageKitUploader;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.GetFileListRequest;
import io.imagekit.sdk.models.results.Result;
import io.imagekit.sdk.models.results.ResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FilesSerivce {

    @Autowired
    private ImageKitUploader imageKitUploader;

    public BaseResponseDTO uploadFile(FileUploadDTO fileUploadDTO) {
        try {
            FileCreateRequest fileCreateRequest = new FileCreateRequest(fileUploadDTO.getContent(), fileUploadDTO.getName());
            fileCreateRequest.setFolder(fileUploadDTO.getFolder());

            Result upload = null;
            HashMap resp = new HashMap();


            upload = imageKitUploader.getUploader().getImageKit().upload(fileCreateRequest);
            if (upload != null) {
                resp.put("url", upload.getUrl());
                resp.put("filePath", upload.getFilePath());
            }

            return new BaseResponseDTO(resp, "Files Uploaded.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
