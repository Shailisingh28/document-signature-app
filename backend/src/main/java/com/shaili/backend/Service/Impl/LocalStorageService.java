package com.shaili.backend.Service.Impl;

import com.shaili.backend.Service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Service
public class LocalStorageService
        implements StorageService {

    private static final String UPLOAD_DIR = "uploads/";

    @Override
    public String saveFile(MultipartFile file) {

        try {

            Path uploadPath = Paths.get("uploads");

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName = System.currentTimeMillis()
                    + "_"
                    + file.getOriginalFilename();

            Path filePath = uploadPath.resolve(fileName);

            Files.copy(
                    file.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING);

            return filePath.toString();

        } catch (IOException e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "File upload failed: " + e.getMessage());
        }
    }
}