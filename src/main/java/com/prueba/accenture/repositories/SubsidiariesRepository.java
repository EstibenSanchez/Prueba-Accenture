package com.prueba.accenture.repositories;

import com.prueba.accenture.models.Subsidiaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsidiariesRepository extends JpaRepository<Subsidiaries, Integer> {

}
