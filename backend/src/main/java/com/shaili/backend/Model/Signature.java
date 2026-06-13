package com.shaili.backend.Model;

import com.shaili.backend.Enums.SignatureStatus;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "signatures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Signature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pageNumber;

    private Float xCoordinate;

    private Float yCoordinate;

    @Enumerated(EnumType.STRING)
    private SignatureStatus status;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "signer_id")
    private User signer;
}