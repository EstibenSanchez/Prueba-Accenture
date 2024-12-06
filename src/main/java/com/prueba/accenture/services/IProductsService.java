package com.prueba.accenture.services;

import com.prueba.accenture.dto.ProductsDto;
import com.prueba.accenture.models.Products;

import java.util.List;

public interface IProductsService {
    public void saveProduct(ProductsDto productDto);
    public List<ProductsDto> getAllProducts();
    public ProductsDto getProductById(int id);
    public void deleteProductById(int id);
    public void updateProduct(ProductsDto productDto);
    public List<ProductsDto> getTopStockProductsByFranchise(int franchiseId);
}
