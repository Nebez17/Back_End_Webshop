package com.example.demo.Model.dto;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;

import java.util.UUID;

public class UserResult {
    public UUID id;
    public String firstName;
    public String lastName;
    public String email;
    public Role role;

    public static UserResult create(User user) {
        UserResult result = new UserResult();
        result.id = user.getId();
        result.email = user.getEmail();
        result.firstName = user.getFirstName();
        result.lastName = user.getLastName();
        result.role = user.getRole();
        return result;
    }
}
