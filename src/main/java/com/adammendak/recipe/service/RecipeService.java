package com.adammendak.recipe.service;

import com.adammendak.recipe.model.Recipe;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findByDescription (String description);

    Recipe findById(Long l);

    Recipe saveRecipe(Recipe recipe);


}
