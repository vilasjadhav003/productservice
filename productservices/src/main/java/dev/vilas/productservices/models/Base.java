package dev.vilas.productservices.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.UuidGenerator;



import java.util.UUID;

@MappedSuperclass
public class Base {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(columnDefinition = "varchar(128)", nullable = false, updatable = false)
    private UUID id;
}
