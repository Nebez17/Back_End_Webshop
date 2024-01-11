package com.example.demo.Model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {

    @NotBlank(message = "Description cannot be blank")
    private String firstName;
    @NotBlank(message = "Description cannot be blank")
    private String lastName;
    @NotBlank(message = "Description cannot be blank")
    private String adres;
    @NotBlank(message = "Description cannot be blank")
    @Size(min = 6)
    private String postcode;
    @NotBlank(message = "Description cannot be blank")
    private String phone;
    @NotBlank(message = "Description cannot be blank")
    private String email;
    private boolean adminRole;
}


