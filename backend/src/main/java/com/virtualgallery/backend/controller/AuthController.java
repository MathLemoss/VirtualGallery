package com.virtualgallery.backend.controller;

import com.virtualgallery.backend.dto.RegisterRequest;
import com.virtualgallery.backend.dto.LoginRequest;
import com.virtualgallery.backend.dto.UpdateProfileRequest;
import com.virtualgallery.backend.model.User;
import com.virtualgallery.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User saved = userService.registerUser(request);
        saved.setPassword(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userService.loginUser(request);
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable String id, @RequestBody UpdateProfileRequest request) {
        User user = userService.updateProfile(id, request);
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }
} 