package com.example.demo.Model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String description;
    private String productName;
    private long price;
    private String imageURL;
    private long stock;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable(
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> category;



    @ManyToMany( mappedBy = "products")
    private Set<Order> orders;


    public Product(String description, String productName, long price, String imageURL, Set<Category> category, long stock) {
        this.description = description;
        this.productName = productName;
        this.price = price;
        this.imageURL = imageURL;
        this.category = category;
        this.stock = stock;
    }

    public Product() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
