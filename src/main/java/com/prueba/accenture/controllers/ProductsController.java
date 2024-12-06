package com.prueba.accenture.controllers;

import com.prueba.accenture.dto.FranchisesDto;
import com.prueba.accenture.dto.ProductsDto;
import com.prueba.accenture.models.Products;
import com.prueba.accenture.services.IProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/products")
public class ProductsController {

    private IProductsService productsService;

    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createProduct(@RequestBody ProductsDto productsDto) {
        productsService.saveProduct(productsDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductsDto productsDto) {
        productsService.updateProduct(productsDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productsService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping ("/get/all")
    public ResponseEntity<List<ProductsDto>> getAllProducts() {
        List<ProductsDto> products = productsService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductsDto> getProductById(@RequestBody ProductsDto productsDto) {
        ProductsDto products =  productsService.getProductById(productsDto.getId());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/top-stock/{franchiseId}")
    public ResponseEntity<List<ProductsDto>> getTopStockProductsByFranchise(@PathVariable int franchiseId) {
        List<ProductsDto> products = productsService.getTopStockProductsByFranchise(franchiseId);
        return ResponseEntity.ok(products);
    }

}
