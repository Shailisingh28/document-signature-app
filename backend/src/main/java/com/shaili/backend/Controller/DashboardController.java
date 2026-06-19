package com.shaili.backend.Controller;

import com.shaili.backend.DTO.DashboardResponse;
import com.shaili.backend.Service.DashboardService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public DashboardResponse getDashboard(
            Authentication authentication) {

        return dashboardService
                .getDashboard(
                        authentication.getName());
    }
}