package com.adammendak.recipe.service;

import com.adammendak.recipe.exceptions.NotFoundException;
import com.adammendak.recipe.model.Recipe;
import com.adammendak.recipe.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);


    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {

        logger.debug("I'm in RecipeServiceImpl");
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long l) {

        Optional<Recipe> recipe = recipeRepository.findById(l);

        if(!recipe.isPresent()) {
            throw new NotFoundException("recipe not found for id value : " + l.toString());
        }
        return recipe.get();
    }

    @Override
    public Recipe findByDescription(String description) {
        return recipeRepository.findByDescription(description);
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {

        Recipe savedRecipe = recipeRepository.save(recipe);
        logger.info("Saved recipe id : " + savedRecipe.getId());
        return savedRecipe;
    }

    @Override
    public void detedeRecipe(Long idTodelete) {
        recipeRepository.delete(idTodelete);
    }
}
