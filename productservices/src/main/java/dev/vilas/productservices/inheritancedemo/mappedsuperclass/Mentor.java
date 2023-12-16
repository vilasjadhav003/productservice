package dev.vilas.productservices.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@Entity(name = "ms_mentor")
public class Mentor extends User {
    private double averageRating;
}
