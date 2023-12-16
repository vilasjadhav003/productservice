package dev.vilas.productservices.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;



import java.util.UUID;

@MappedSuperclass
public class Base {
    @Id
    @GeneratedValue(generator = "vilas-uuid-generator")
    @GenericGenerator(name = "vilas-uuid-generator", strategy = "uuid2")
    private UUID uuid;
}
