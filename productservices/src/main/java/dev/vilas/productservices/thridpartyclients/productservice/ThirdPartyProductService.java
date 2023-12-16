package dev.vilas.productservices.thridpartyclients.productservice;

import dev.vilas.productservices.thridpartyclients.productservice.Fakestore.FakeStoreProductDTO;
import dev.vilas.productservices.dtos.GenericProductDTO;
import dev.vilas.productservices.exception.NotFoundException;

import java.util.List;

public interface ThirdPartyProductService {

    public FakeStoreProductDTO getProductById(Long id) throws NotFoundException;

    public List<FakeStoreProductDTO> getAllProducts();

    public FakeStoreProductDTO deleteProductById(Long id);

    public FakeStoreProductDTO createProduct(GenericProductDTO genericProductDTO);

    public FakeStoreProductDTO updateProduct(GenericProductDTO genericProductDTO, Long id);
}
