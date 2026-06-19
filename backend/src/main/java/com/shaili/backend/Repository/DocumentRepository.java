package com.shaili.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaili.backend.Enums.DocumentStatus;
import com.shaili.backend.Model.Document;
import com.shaili.backend.Model.User;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByOwner(User owner);

    long countByOwner(User owner);

    long countByOwnerAndStatus(
            User owner,
            DocumentStatus status);
}
