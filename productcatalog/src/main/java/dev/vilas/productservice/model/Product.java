package dev.vilas.productservice.model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class Product extends Base{
    private String title;
    private int price;
    private String image;
    private String description;

    public Product() {

    }

    public Product(String title, String description, String image, int price) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
    }
}
