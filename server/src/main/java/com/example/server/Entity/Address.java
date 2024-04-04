package com.example.server.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @JsonIgnore
    @ManyToOne
    private City city;
    @JsonIgnore
    @ManyToOne
    private District district;
    @JsonIgnore
    @ManyToOne
    private Wards wards;
    @OneToOne
    @JsonIgnore
    private User user;
}
