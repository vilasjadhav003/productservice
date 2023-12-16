package dev.vilas.productservices.service;

import dev.vilas.productservices.converter.FakeStoreToGenericProductConverter;
import dev.vilas.productservices.dtos.GenericProductDTO;
import dev.vilas.productservices.exception.NotFoundException;
import dev.vilas.productservices.thridpartyclients.productservice.ThirdPartyProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakeStoreProductService implements  ProductService{
    private FakeStoreToGenericProductConverter fakeStoreToGenericProductConverter;

    private ThirdPartyProductService thirdPartyProductService;
    public FakeStoreProductService(FakeStoreToGenericProductConverter fakeStoreToGenericProductConverter, ThirdPartyProductService thirdPartyProductService) {
        this.fakeStoreToGenericProductConverter = fakeStoreToGenericProductConverter;
        this.thirdPartyProductService = thirdPartyProductService;
    }
    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException {

        return fakeStoreToGenericProductConverter.convert(thirdPartyProductService.getProductById(id));

    }

    @Override
    public List<GenericProductDTO> getAllProducts() {

        return thirdPartyProductService.getAllProducts().stream()
                .map(fakeStoreProductDTO -> fakeStoreToGenericProductConverter.convert(fakeStoreProductDTO))
                .collect(Collectors.toList());
    }

    @Override
    public GenericProductDTO deleteProductById(Long id) {
        return fakeStoreToGenericProductConverter.convert(thirdPartyProductService.deleteProductById(id));
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        return fakeStoreToGenericProductConverter.convert(thirdPartyProductService.createProduct(genericProductDTO));
    }

    @Override
    public GenericProductDTO updateProduct(GenericProductDTO genericProductDTO, Long id) {

        return fakeStoreToGenericProductConverter.convert(thirdPartyProductService.updateProduct(genericProductDTO,id));

    }
}
