package com.adammendak.recipe.service;

import com.adammendak.recipe.model.Ingredient;
import com.adammendak.recipe.model.Recipe;
import com.adammendak.recipe.repository.RecipeRepository;
import com.adammendak.recipe.repository.UnitOfMeasureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    Logger logger = LoggerFactory.getLogger(IngredientServiceImpl.class);

    public IngredientServiceImpl(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Optional<Ingredient> findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(!recipeOptional.isPresent()) {
            logger.error("recipe not found id:" + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<Ingredient> ingredient = recipe.getIngredients().stream()
                .filter(i -> i.getId().equals(ingredientId))
                .findFirst();

        if(!ingredient.isPresent()){
            logger.error("ingredient not found with id :" +ingredientId);
        }


        return ingredient;
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient, Recipe recipeId) {


        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId.getId());

        if(!recipeOptional.isPresent()) {
            logger.error("recipe not found id:" + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        ingredient.setRecipe(recipe);
        ingredient.setUnitOfMeasure(ingredient.getUnitOfMeasure());

        recipe.addIngredient(ingredient);
        recipeRepository.save(recipe);

        Optional<Ingredient> savedIngredient = recipe.getIngredients().stream()
                .filter(i -> i.getRecipe().equals(ingredient.getRecipe()))
                .filter(i -> i.getDescription().equals(ingredient.getDescription()))
                .findFirst();

        if(!savedIngredient.isPresent()) {
            logger.error("no present ingredient");
        }


        //debuggind
        logger.info(ingredient.toString());
        logger.info("added ingredient id " + savedIngredient.get().getId() + "to recipe id " + recipe.getId());
        logger.info(savedIngredient.toString());
        logger.error(savedIngredient.toString());

        return savedIngredient.get();
    }

    @Override
    public void deleteById(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(!recipeOptional.isPresent()) {
            logger.error("recipe not found id:" + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<Ingredient> ingredient = recipe.getIngredients().stream()
                .filter(i -> i.getId().equals(ingredientId))
                .findFirst();

        if(!ingredient.isPresent()){
            logger.error("ingredient not found with id :" +ingredientId);
        }

        recipe.getIngredients().remove(ingredient.get());

    }
}
