package com.adammendak.recipe.repository;

import com.adammendak.recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Recipe findByDescription (String description);

    Set<Recipe> findAll();
}
