package com.adammendak.recipe.repository;

import com.adammendak.recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByDescription (String description);
}
