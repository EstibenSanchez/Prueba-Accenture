package com.prueba.accenture.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(nullable = false, length = 50)
    private String name;
    @Basic
    @Column(nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "subsidiary_id")
    private Subsidiaries subsidiary;
}
