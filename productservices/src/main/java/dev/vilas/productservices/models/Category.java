package dev.vilas.productservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends Base {
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Product> products;

    // this is the same relation being mapped by category attribute in the other (Product) class
}
