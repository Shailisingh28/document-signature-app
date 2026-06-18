package com.shaili.backend.Service;

import java.util.List;

import com.shaili.backend.DTO.PendingSignatureResponse;
import com.shaili.backend.DTO.SignatureRequest;
import com.shaili.backend.Model.Signature;

public interface SignatureService {

    Signature createSignature(
            SignatureRequest request);

    List<PendingSignatureResponse> getPendingSignatures(
            String email);

    Signature signDocument(
            Long signatureId,
            String signatureValue);
}