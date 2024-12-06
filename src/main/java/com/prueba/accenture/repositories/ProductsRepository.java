package com.prueba.accenture.repositories;

import com.prueba.accenture.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    @Query("SELECT p FROM Products p WHERE p.subsidiary.franchise.id = :franchiseId " +
            "AND p.stock = (SELECT MAX(p2.stock) FROM Products p2 WHERE p2.subsidiary.id = p.subsidiary.id)")
    List<Products> findTopStockProductsByFranchise(int franchiseId);
}
