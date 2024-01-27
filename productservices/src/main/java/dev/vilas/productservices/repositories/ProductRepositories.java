package dev.vilas.productservices.repositories;

import dev.vilas.productservices.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepositories extends JpaRepository<Product, UUID> {

    @Override
    <S extends Product> S save(S entity);
}
