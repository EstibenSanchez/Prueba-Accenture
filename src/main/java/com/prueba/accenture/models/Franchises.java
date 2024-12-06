package com.prueba.accenture.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Data
public class Franchises {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "franchise", fetch = FetchType.LAZY, targetEntity = Subsidiaries.class)
    private List<Subsidiaries> subsidiaries;
}
