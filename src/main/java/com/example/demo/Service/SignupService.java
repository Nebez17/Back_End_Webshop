package com.example.demo.Service;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Model.dto.SignUpRequest;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User signup(SignUpRequest request) {
        var user = User.builder().adres(request.getAdres())
                .adres(request.getAdres())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .postcode(request.getPostcode())
                .phone(request.getPhone())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.isAdminRole() ? Role.ADMIN : Role.CUSTOMER)
                .build();
        return userRepository.save(user);
    }
}
