package dev.vilas.productservices.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericProductDTO {
    private long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private String price;
}
