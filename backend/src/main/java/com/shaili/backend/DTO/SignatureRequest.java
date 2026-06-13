package com.shaili.backend.DTO;

import lombok.Data;

@Data
public class SignatureRequest {

    private Long documentId;

    private Long signerId;

    private Integer pageNumber;

    private Float xCoordinate;

    private Float yCoordinate;
}