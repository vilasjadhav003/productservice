package dev.vilas.productservices.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "ms_Student")
public class Student extends User {
    private double psp;
    private double attendance;
}
