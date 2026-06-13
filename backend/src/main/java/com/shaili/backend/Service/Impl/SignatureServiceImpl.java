package com.shaili.backend.Service.Impl;

import com.shaili.backend.DTO.SignatureRequest;
import com.shaili.backend.Enums.SignatureStatus;
import com.shaili.backend.Model.Document;
import com.shaili.backend.Model.Signature;
import com.shaili.backend.Model.User;
import com.shaili.backend.Repository.DocumentRepository;
import com.shaili.backend.Repository.SignatureRepository;
import com.shaili.backend.Repository.UserRepository;
import com.shaili.backend.Service.SignatureService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignatureServiceImpl
        implements SignatureService {

    private final SignatureRepository signatureRepository;

    private final DocumentRepository documentRepository;

    private final UserRepository userRepository;

    @Override
    public Signature createSignature(
            SignatureRequest request) {

        Document document = documentRepository
                .findById(
                        request.getDocumentId())
                .orElseThrow();

        User signer = userRepository
                .findById(
                        request.getSignerId())
                .orElseThrow();

        Signature signature = Signature.builder()
                .document(document)
                .signer(signer)
                .pageNumber(
                        request.getPageNumber())
                .xCoordinate(
                        request.getXCoordinate())
                .yCoordinate(
                        request.getYCoordinate())
                .status(
                        SignatureStatus.PENDING)
                .build();

        return signatureRepository
                .save(signature);
    }
}