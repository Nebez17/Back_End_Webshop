package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Category")
public class Category {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(unique = true)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL ,mappedBy = "category")
    @JsonIgnore
    private Set<Product> products;

    public Category(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Category() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}