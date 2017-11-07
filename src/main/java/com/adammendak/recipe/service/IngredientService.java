package com.adammendak.recipe.service;

import com.adammendak.recipe.model.Ingredient;
import com.adammendak.recipe.model.Recipe;

import java.util.Optional;

public interface IngredientService {

    Optional<Ingredient> findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    Ingredient saveIngredient (Ingredient ingredient, Recipe recipe );

    void deleteById(Long recipeId, Long ingredientId);



}
