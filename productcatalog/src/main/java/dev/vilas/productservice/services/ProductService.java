package dev.vilas.productservice.services;

import dev.vilas.productservice.dtos.GenericProductDto;
import dev.vilas.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);
}
