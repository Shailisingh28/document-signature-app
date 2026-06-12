package com.shaili.backend.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentResponse {

    private Long id;

    private String fileName;

    private String status;
}