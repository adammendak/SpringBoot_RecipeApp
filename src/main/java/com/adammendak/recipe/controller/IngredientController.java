package com.adammendak.recipe.controller;

import com.adammendak.recipe.model.Ingredient;
import com.adammendak.recipe.model.Recipe;
import com.adammendak.recipe.service.IngredientService;
import com.adammendak.recipe.service.RecipeService;
import com.adammendak.recipe.service.UnitOfMeasureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;
    private final RecipeService recipeService;
    private final UnitOfMeasureService unitOfMeasureService;

    Logger logger = LoggerFactory.getLogger(IngredientController.class);

    public IngredientController(IngredientService ingredientService, RecipeService recipeService, UnitOfMeasureService unitOfMeasureService) {
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @RequestMapping(value = "/recipe/{id}/ingredients", method = RequestMethod.GET)
    public String getIngredientsList(@PathVariable String id, Model model) {
        logger.info("getting lists of ingredients for recipe no: " + id);
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/ingredients/list";
    }

    @RequestMapping(value = "recipe/{recipeId}/ingredient/{id}/show", method = RequestMethod.GET)
    public String showRecipeIngredient (@PathVariable String recipeId, @PathVariable String id, Model model) {

        Ingredient ingredient = ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)).get();

        logger.info("ingredient :" + ingredient.toString());
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("recipe", recipeService.findById(new Long(recipeId)));

        return "recipe/ingredients/show";
    }

    @RequestMapping(value = "recipe/{recipeId}/ingredient/new", method = RequestMethod.GET)
    public String newIngredient(@PathVariable String recipeId, Model model) {

        model.addAttribute("recipe", recipeService.findById(new Long(recipeId)));
        model.addAttribute("uom", unitOfMeasureService.getAll());
        model.addAttribute("ingredient", new Ingredient());

        return "recipe/ingredients/ingredientForm";
    }

    @RequestMapping(value = "recipe/{recipeId}/ingredient/{id}/update", method = RequestMethod.GET)
    public String updateIngredient(@PathVariable String recipeId, @PathVariable String id, Model model) {

        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        model.addAttribute("recipe", recipeService.findById(new Long(recipeId)));
        model.addAttribute("uom", unitOfMeasureService.getAll());

        return "recipe/ingredients/ingredientForm";
    }

    @RequestMapping(value = "recipe/{recipeId}/ingredient", method = RequestMethod.POST)
    public String saveOrUpdateIngredient(@ModelAttribute Ingredient ingredient, @PathVariable String recipeId) {

        Recipe recipe = recipeService.findById(new Long(recipeId));

        Ingredient ingredientToSave = ingredientService.saveIngredient(ingredient, recipe);

        logger.info("igredient to save id :" + ingredientToSave.getId());

        return "redirect:/recipe/" + recipeId + "/ingredient/" + ingredientToSave.getId() + "/show";
    }

    @RequestMapping(value = "recipe/{recipeId}/ingredient/{id}/delete", method = RequestMethod.DELETE)
    public String deleteIngredient(@PathVariable String recipeId, @PathVariable String id) {
        logger.info("deleting ingredient id:" + id);
        ingredientService.deleteById(Long.valueOf(recipeId), Long.valueOf(id));

        return "redirect:/recipe/" + recipeId + "/ingredients";
    }





}
