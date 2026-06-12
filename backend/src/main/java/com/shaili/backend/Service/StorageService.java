package com.shaili.backend.Service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    String saveFile(MultipartFile file);
}
