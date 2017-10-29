package com.adammendak.recipe.controller;

import com.adammendak.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    public final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe")
    public String getProduct(Model model) {
        model.addAttribute("recipe", recipeService.findByDescription("pizza"));


        return "recipe";
    }
}
