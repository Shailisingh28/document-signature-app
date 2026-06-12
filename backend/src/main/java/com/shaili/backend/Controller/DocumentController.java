package com.shaili.backend.Controller;

import com.shaili.backend.DTO.DocumentResponse;
import com.shaili.backend.Model.Document;
import com.shaili.backend.Service.DocumentService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/upload")
    public Document uploadDocument(
            @RequestParam("file") MultipartFile file,
            Authentication authentication) {

        return documentService.uploadDocument(
                file,
                authentication.getName());
    }

    @GetMapping
    public List<DocumentResponse> getDocuments(
            Authentication authentication) {

        return documentService.getUserDocuments(
                authentication.getName());
    }
}