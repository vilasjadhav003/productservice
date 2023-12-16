package dev.vilas.productservices.inheritancedemo.singletable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "st_User")
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue("0")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
