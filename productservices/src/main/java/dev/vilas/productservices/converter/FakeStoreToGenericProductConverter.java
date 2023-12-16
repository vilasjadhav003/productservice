package dev.vilas.productservices.converter;

import dev.vilas.productservices.thridpartyclients.productservice.Fakestore.FakeStoreProductDTO;
import dev.vilas.productservices.dtos.GenericProductDTO;


public interface FakeStoreToGenericProductConverter {

    public GenericProductDTO convert(FakeStoreProductDTO fakeStoreProductDTO);
}
