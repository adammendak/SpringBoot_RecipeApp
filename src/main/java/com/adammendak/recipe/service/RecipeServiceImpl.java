package com.adammendak.recipe.service;

import com.adammendak.recipe.model.Recipe;
import com.adammendak.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }
}
