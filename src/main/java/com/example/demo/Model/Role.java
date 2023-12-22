package com.example.demo.Model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "_role")
public class Role {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "role")
    private Set<User> user;
}
