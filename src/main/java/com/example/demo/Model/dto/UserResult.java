package com.example.demo.Model.dto;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;

import java.util.UUID;

public class UserResult {
    public UUID id;
    public String firstName;
    public String lastName;
    public String adres;
    public String postcode;
    public String phone;
    public String email;
    public String password;
    public Role role;

    public static UserResult create(User user) {
        UserResult result = new UserResult();
        result.id = user.getId();
        result.firstName = user.getFirstName();
        result.lastName = user.getLastName();
        result.adres = user.getAdres();
        result.postcode = user.getPostcode();
        result.phone = user.getPhone();
        result.email = user.getEmail();
        result.password = user.getPassword();
        result.role = user.getRole();
        return result;
    }
}
