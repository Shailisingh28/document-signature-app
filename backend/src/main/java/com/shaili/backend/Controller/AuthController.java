package com.shaili.backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaili.backend.DTO.AuthResponse;
import com.shaili.backend.DTO.LoginRequest;
import com.shaili.backend.DTO.RegisterRequest;
import com.shaili.backend.Model.User;
import com.shaili.backend.Repository.UserRepository;
import com.shaili.backend.Security.JwtUtil;
import com.shaili.backend.Service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()));

        User user = userRepository.findByEmail(request.getEmail()).get();

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().name());

        return ResponseEntity.ok(new AuthResponse(token));
    }

}
