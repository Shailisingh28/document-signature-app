package com.shaili.backend.Controller;

import com.shaili.backend.DTO.PendingSignatureResponse;
import com.shaili.backend.DTO.SignRequest;
import com.shaili.backend.DTO.SignatureRequest;
import com.shaili.backend.Model.Signature;
import com.shaili.backend.Service.SignatureService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signatures")
@RequiredArgsConstructor
public class SignatureController {

    private final SignatureService signatureService;

    @PostMapping
    public Signature createSignature(
            @RequestBody SignatureRequest request) {

        return signatureService
                .createSignature(request);
    }

    @GetMapping("/pending")
    public List<PendingSignatureResponse> pendingSignatures(
            Authentication authentication) {

        return signatureService
                .getPendingSignatures(
                        authentication.getName());
    }

    @PostMapping("/{id}/sign")
    public Signature signDocument(
            @PathVariable Long id,
            @RequestBody SignRequest request) {

        return signatureService
                .signDocument(
                        id,
                        request.getSignatureText());
    }
}