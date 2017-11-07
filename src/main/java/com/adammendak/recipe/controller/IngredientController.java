package com.adammendak.recipe.controller;

import com.adammendak.recipe.service.IngredientService;
import com.adammendak.recipe.service.RecipeService;
import com.adammendak.recipe.service.UnitOfMeasureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

    @RequestMapping(value = "/recipe/{id}/ingredients", method = GET)
    public String getIngredientsList(@PathVariable String id, Model model) {
        logger.info("getting lists of ingredients for recipe no: " + id);
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/ingredient/list";
    }



}
