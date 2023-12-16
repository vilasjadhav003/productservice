package dev.vilas.productservices.inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "st_ta")
@DiscriminatorValue("3")
public class TA extends User{
    private double averageRating;
}
