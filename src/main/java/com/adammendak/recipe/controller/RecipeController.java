package com.adammendak.recipe.controller;
import com.adammendak.recipe.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    public final RecipeService recipeService;

    Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String getById(@PathVariable String id, Model model) {

        logger.info("going into recipe no " + id);
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";

    }

}
