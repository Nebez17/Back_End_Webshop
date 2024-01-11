package com.example.demo.Service;

import com.example.demo.Exeptions.NotFoundException;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public void delete(long id) throws NotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new NotFoundException("User with id: " + id + " not found");
        }

        User user = optionalUser.get();
        this.userRepository.delete(user);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteUser(UUID id){
        userRepository.deleteUserById(id);
    }
}
