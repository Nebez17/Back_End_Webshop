package com.example.demo.Model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.List;

@Data

public class ProductDto {

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Product name cannot be blank")
    private String productName;

    @Positive(message = "Stock must be a positive value")
    private long price;

    @Positive(message = "Stock must be a positive value")
    private long stock;

    @NotBlank(message = "Image URL cannot be blank")
    private String imageURL;

    @NotNull(message = "Category list cannot be null")
    @Size(min = 1, max = 10, message = "At least one category must be specified")
    private List<String> category;
}
