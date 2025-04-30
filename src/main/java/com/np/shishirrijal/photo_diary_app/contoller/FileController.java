package com.np.shishirrijal.photo_diary_app.contoller;

import com.np.shishirrijal.photo_diary_app.service.AzureBlobStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private AzureBlobStorageService azureBlobStorageService;


    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("photo") MultipartFile photo) {
        Map<String, String> response = new HashMap<>();
        try {
            if (photo == null || photo.isEmpty()) {
                response.put("error", "File is empty.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            // Validate file type
            String mimeType = photo.getContentType();
            if (!"image/jpeg".equals(mimeType) && !"image/png".equals(mimeType)) {
                response.put("error", "Invalid file type. Only JPEG and PNG files are allowed.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            String imageUrl = azureBlobStorageService.uploadFile(photo);
            response.put("imageUrl", imageUrl);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception for debugging
            System.out.println("Error uploading file" + e);
            response.put("error", "File upload failed due to an internal error.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}


