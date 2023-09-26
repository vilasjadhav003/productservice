package dev.vilas.productservice.dtos;

import lombok.Data;

@Data
public class GenericProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
