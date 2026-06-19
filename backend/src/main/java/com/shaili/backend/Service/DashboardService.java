package com.shaili.backend.Service;

import com.shaili.backend.DTO.DashboardResponse;

public interface DashboardService {

    DashboardResponse getDashboard(
            String email);
}