package dev.vilas.productservices.repositories;

import dev.vilas.productservices.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepositories extends JpaRepository<Category, UUID> {
    @Override
    <S extends Category> S save(S entity);
}
