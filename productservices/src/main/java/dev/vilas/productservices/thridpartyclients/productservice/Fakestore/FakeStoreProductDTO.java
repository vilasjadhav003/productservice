package dev.vilas.productservices.thridpartyclients.productservice.Fakestore;

import lombok.Data;

@Data
public class FakeStoreProductDTO {
    private long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private String price;
}
