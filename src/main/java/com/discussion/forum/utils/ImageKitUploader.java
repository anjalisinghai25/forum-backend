package com.discussion.forum.utils;

import com.discussion.forum.dtos.ImageKitDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ImageKitUploader {

    public ImageKitDTO getUploader() throws IOException {
        String publicKey = "public_OLZ8L2I6VtMEH+8xWMz96tGPyIo==";
        String privateKey = "private_OwpvX/gz7a2H0P4YDmTueZn414c=";
        String urlEndPoint = "https://ik.imagekit.io/iqsmp1b5t";
        return new ImageKitDTO(publicKey, privateKey, urlEndPoint);
    }


}
