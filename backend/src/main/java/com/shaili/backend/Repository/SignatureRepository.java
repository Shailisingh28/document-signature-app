package com.shaili.backend.Repository;

import com.shaili.backend.Model.Signature;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SignatureRepository
        extends JpaRepository<Signature, Long> {

    List<Signature> findByDocumentId(Long documentId);

}