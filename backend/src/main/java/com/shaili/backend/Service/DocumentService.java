package com.shaili.backend.Service;

import com.shaili.backend.DTO.DocumentResponse;
import com.shaili.backend.Model.Document;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {

    Document uploadDocument(
            MultipartFile file,
            String email);

    List<DocumentResponse> getUserDocuments(
            String email);
}