package dev.vilas.productservice.thirdpartyclients.productsservice.fakestore;

import lombok.Data;

@Data
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
