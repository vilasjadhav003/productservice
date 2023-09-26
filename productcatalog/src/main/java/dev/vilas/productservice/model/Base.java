package dev.vilas.productservice.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Base {
    @Id
    private long id;
}
