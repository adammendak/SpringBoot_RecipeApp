package com.adammendak.recipe.repository;

import com.adammendak.recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findByDescription(String description);

    Set<Category> findAll();

}
