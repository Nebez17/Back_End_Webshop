package com.example.demo.Service;

import com.example.demo.Exeptions.NotFoundException;
import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Model.dto.ProductDto;
import com.example.demo.Model.dto.SignUpRequest;
import com.example.demo.Model.dto.UpdateUserDto;
import com.example.demo.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }



    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteUser(UUID id){
        userRepository.deleteUserById(id);
    }


    public User updateUser(String email, UpdateUserDto request) {
        User existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + email));
            existingUser.setFirstName(request.getFirstName());
            existingUser.setLastName(request.getLastName());
            existingUser.setAdres(request.getAdres());
            existingUser.setPostcode(request.getPostcode());
            existingUser.setPhone(request.getPhone());
            existingUser.setEmail(request.getEmail());
            existingUser.setRole(request.isAdminRole() ? Role.ADMIN : Role.CUSTOMER);
            return userRepository.save(existingUser);
        };

}
