package com.shaili.backend.Service.Impl;

import com.shaili.backend.DTO.DashboardResponse;
import com.shaili.backend.Enums.DocumentStatus;
import com.shaili.backend.Model.User;
import com.shaili.backend.Repository.DocumentRepository;
import com.shaili.backend.Repository.UserRepository;
import com.shaili.backend.Service.DashboardService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl
        implements DashboardService {

    private final UserRepository userRepository;

    private final DocumentRepository documentRepository;

    @Override
    public DashboardResponse getDashboard(
            String email) {

        User owner = userRepository
                .findByEmail(email)
                .orElseThrow();

        return DashboardResponse
                .builder()
                .totalDocuments(
                        documentRepository
                                .countByOwner(owner))

                .pendingDocuments(
                        documentRepository
                                .countByOwnerAndStatus(
                                        owner,
                                        DocumentStatus.PENDING))

                .sentDocuments(
                        documentRepository
                                .countByOwnerAndStatus(
                                        owner,
                                        DocumentStatus.SENT))

                .signedDocuments(
                        documentRepository
                                .countByOwnerAndStatus(
                                        owner,
                                        DocumentStatus.SIGNED))
                .build();
    }
}