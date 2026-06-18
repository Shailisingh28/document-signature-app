package com.shaili.backend.Repository;

import com.shaili.backend.Enums.SignatureStatus;
import com.shaili.backend.Model.Signature;
import com.shaili.backend.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SignatureRepository
        extends JpaRepository<Signature, Long> {

    List<Signature> findByDocumentId(Long documentId);

    List<Signature> findBySignerEmailAndStatus(
            String email,
            SignatureStatus status);

    List<Signature> findBySignerAndStatus(
            User signer,
            SignatureStatus status);

}