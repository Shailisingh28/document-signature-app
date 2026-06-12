package com.shaili.backend.Service.Impl;

import com.shaili.backend.Model.Document;
import com.shaili.backend.Model.User;
import com.shaili.backend.DTO.DocumentResponse;
import com.shaili.backend.Enums.DocumentStatus;
import com.shaili.backend.Repository.DocumentRepository;
import com.shaili.backend.Repository.UserRepository;
import com.shaili.backend.Service.DocumentService;
import com.shaili.backend.Service.StorageService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl
        implements DocumentService {

    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;
    private final StorageService storageService;

    @Override
    public Document uploadDocument(
            MultipartFile file,
            String email) {

        User owner = userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new RuntimeException("User not found"));

        String filePath = storageService.saveFile(file);

        Document document = Document.builder()
                .fileName(file.getOriginalFilename())
                .filePath(filePath)
                .status(DocumentStatus.PENDING)
                .uploadedAt(LocalDateTime.now())
                .owner(owner)
                .build();

        return documentRepository.save(document);
    }

    @Override
    public List<DocumentResponse> getUserDocuments(
            String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new RuntimeException("User not found"));

        return documentRepository
                .findByOwner(user)
                .stream()
                .map(document -> DocumentResponse.builder()
                        .id(document.getId())
                        .fileName(document.getFileName())
                        .status(document.getStatus().name())
                        .build())
                .toList();
    }
}