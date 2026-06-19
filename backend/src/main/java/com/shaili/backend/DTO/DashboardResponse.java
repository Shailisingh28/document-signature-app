package com.shaili.backend.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResponse {

    private Long totalDocuments;

    private Long pendingDocuments;

    private Long sentDocuments;

    private Long signedDocuments;
}