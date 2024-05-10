package com.example.highschool.global.security.filter;

import com.example.highschool.domain.AccessPoint;
import com.example.highschool.global.security.SecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class SecurityFilter implements Filter {
    private AccessPoint accessPoint;
    private final SecurityConfig securityConfig;
    private final ObjectMapper objectMapper;
    @Override
    public void init(FilterConfig filterConfig) {
        this.accessPoint = securityConfig.accessPoint();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String accessHeaderValue = httpRequest.getHeader("Authorization");

        String uri = httpRequest.getRequestURI();
        if (accessPoint.permissionsCheck(uri, accessHeaderValue)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpResponse.setContentType("application/json");
            httpResponse.getOutputStream().write(
                objectMapper.writeValueAsString(
                    new ResponseEntity<>(
                        "Require Permission Access, your access = " +
                        accessHeaderValue,
                        HttpStatus.FORBIDDEN
                    )
                ).getBytes(StandardCharsets.UTF_8)
            );
        }
    }
}
