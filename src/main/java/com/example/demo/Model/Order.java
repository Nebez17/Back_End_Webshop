package com.example.demo.Model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "_Order")
public class Order {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;
    @ManyToOne
    private User user;

    private long price;

    private Date time;
    private boolean status;

    public Order(Set<Product> products, User user, long price, Date time, boolean status) {
        this.products = products;
        this.user = user;
        this.price = price;
        this.time = time;
        this.status = status;
    }

    public Order() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
