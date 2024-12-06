package com.prueba.accenture.services.impl;

import com.prueba.accenture.dto.FranchisesDto;
import com.prueba.accenture.dto.ProductsDto;
import com.prueba.accenture.dto.SubsidiariesDto;
import com.prueba.accenture.models.Products;
import com.prueba.accenture.models.Subsidiaries;
import com.prueba.accenture.repositories.ProductsRepository;
import com.prueba.accenture.repositories.SubsidiariesRepository;
import com.prueba.accenture.services.IProductsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdcutsServices implements IProductsService {
    private ProductsRepository productsRepository;
    private SubsidiariesRepository subsidiariesRepository;

    public ProdcutsServices(ProductsRepository productsRepository, SubsidiariesRepository subsidiariesRepository) {
        this.productsRepository = productsRepository;
        this.subsidiariesRepository = subsidiariesRepository;
    }

    @Override
    public void saveProduct(ProductsDto productDto) {
        Products product = new Products();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setStock(productDto.getStock());
        Subsidiaries subsidiaries = subsidiariesRepository.findById(productDto.getSubsidiary_id()).get();
        product.setSubsidiary(subsidiaries);
        productsRepository.save(product);
    }

    @Override
    public List<ProductsDto> getAllProducts() {
        return productsRepository.findAll().stream()
                .map(product -> {
                    SubsidiariesDto subsidiariesDto = SubsidiariesDto.builder()
                            .id(product.getSubsidiary().getId())
                            .name(product.getSubsidiary().getName())
                            .build();
                    return ProductsDto.builder()
                            .id(product.getId())
                            .name(product.getName())
                            .stock(product.getStock())
                            .subsidiary(subsidiariesDto)
                            .build();
                })
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void deleteProductById(int id) {
        productsRepository.deleteById(id);
    }

    @Override
    public void updateProduct(ProductsDto productDto) {
        Products product = productsRepository.findById(productDto.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDto.getName());
        product.setStock(productDto.getStock());
        productsRepository.save(product);
    }

    @Override
    public ProductsDto getProductById(int id) {
        Products product = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        SubsidiariesDto subsidiariesDto = SubsidiariesDto.builder()
                .id(product.getSubsidiary().getId())
                .name(product.getSubsidiary().getName())
                .build();

        return ProductsDto.builder()
                .id(product.getId())
                .name(product.getName())
                .stock(product.getStock())
                .subsidiary(subsidiariesDto)
                .build();
    }

    @Override
    public List<ProductsDto> getTopStockProductsByFranchise(int franchiseId) {
        List<Products> products = productsRepository.findTopStockProductsByFranchise(franchiseId);
        return products.stream().map(product -> ProductsDto.builder()
                .id(product.getId())
                .name(product.getName())
                .stock(product.getStock())
                .subsidiary_id(product.getSubsidiary().getId())
                .build()).collect(Collectors.toList());
    }

}
