package dev.vilas.productservices.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@Entity(name = "ms_ta")
public class TA extends User {
    private double averageRating;
}
