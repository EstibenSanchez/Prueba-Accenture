package com.prueba.accenture.repositories;

import com.prueba.accenture.models.Franchises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FranchisesRepository extends JpaRepository<Franchises, Integer> {

}
