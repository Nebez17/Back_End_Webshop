package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Model.dto.ProductDto;
import com.example.demo.Model.dto.UpdateUserDto;
import com.example.demo.Model.dto.UserResult;
import com.example.demo.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserResult> findAll(){
        return this.userService.findAll().stream()
                .map(UserResult::create)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") UUID id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable("email") String email, @RequestBody UpdateUserDto updateUserDto) {
        User updated = userService.updateUser(email, updateUserDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
