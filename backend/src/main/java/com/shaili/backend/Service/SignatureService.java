package com.shaili.backend.Service;

import com.shaili.backend.DTO.SignatureRequest;
import com.shaili.backend.Model.Signature;

public interface SignatureService {

    Signature createSignature(
            SignatureRequest request);
}