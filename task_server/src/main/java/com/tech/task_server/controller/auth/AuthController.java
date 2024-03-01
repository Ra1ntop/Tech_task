package com.tech.task_server.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.tech.task_server.config.security.AuthenticationService;
import com.tech.task_server.dto.request.auth.RegisterDto;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(authenticationService.register(registerDto));

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(authenticationService.login(registerDto));

    }
}