package com.shaili.backend.Controller;

import com.shaili.backend.DTO.SignatureRequest;
import com.shaili.backend.Model.Signature;
import com.shaili.backend.Service.SignatureService;

import lombok.RequiredArgsConstructor;

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
}