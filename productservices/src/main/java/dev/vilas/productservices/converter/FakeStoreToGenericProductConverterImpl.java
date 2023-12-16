package dev.vilas.productservices.converter;

import dev.vilas.productservices.thridpartyclients.productservice.Fakestore.FakeStoreProductDTO;
import dev.vilas.productservices.dtos.GenericProductDTO;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreToGenericProductConverterImpl implements FakeStoreToGenericProductConverter{
    @Override
    public GenericProductDTO convert(FakeStoreProductDTO fakeStoreProductDTO) {

            return GenericProductDTO.builder()
                    .price(fakeStoreProductDTO.getPrice())
                    .title(fakeStoreProductDTO.getTitle())
                    .image(fakeStoreProductDTO.getImage())
                    .description(fakeStoreProductDTO.getDescription())
                    .category(fakeStoreProductDTO.getCategory())
                    .id(fakeStoreProductDTO.getId())
                    .build();

    }
}
