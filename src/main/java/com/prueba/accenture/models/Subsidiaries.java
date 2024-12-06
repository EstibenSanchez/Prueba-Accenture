package com.prueba.accenture.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Subsidiaries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchises franchise;

    @OneToMany(mappedBy = "subsidiary", fetch = FetchType.LAZY, targetEntity = Products.class)
    private List<Products> products;
}
