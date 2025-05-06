package com.virtualgallery.backend.service;

import com.virtualgallery.backend.dto.RegisterRequest;
import com.virtualgallery.backend.dto.LoginRequest;
import com.virtualgallery.backend.dto.UpdateProfileRequest;
import com.virtualgallery.backend.model.User;
import com.virtualgallery.backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    public User registerUser(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado");
        }
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Hash da senha
        user.setInstagram(request.getInstagram());
        user.setLinkedin(request.getLinkedin());
        user.setBio(request.getBio());
        return userRepository.save(user);
    }

    public User loginUser(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário não encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Senha incorreta");
        }

        return user;
    }

    public User updateProfile(String id, UpdateProfileRequest request) {
        User user = getUserById(id);
        user.setInstagram(request.getInstagram());
        user.setLinkedin(request.getLinkedin());
        user.setBio(request.getBio());
        return userRepository.save(user);
    }
}

