package dev.vilas.productservices.service;

import dev.vilas.productservices.dtos.GenericProductDTO;
import dev.vilas.productservices.exception.NotFoundException;

import java.util.List;

public interface ProductService {

    public GenericProductDTO getProductById(Long id) throws NotFoundException;

    public List<GenericProductDTO> getAllProducts();

    public GenericProductDTO deleteProductById(Long id);

    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

    public GenericProductDTO updateProduct(GenericProductDTO genericProductDTO, Long id);
}
