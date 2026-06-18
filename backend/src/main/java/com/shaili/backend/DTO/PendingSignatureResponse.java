package com.shaili.backend.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PendingSignatureResponse {

    private Long signatureId;

    private Long documentId;

    private String documentName;

    private Integer pageNumber;

    private Float xCoordinate;

    private Float yCoordinate;
}