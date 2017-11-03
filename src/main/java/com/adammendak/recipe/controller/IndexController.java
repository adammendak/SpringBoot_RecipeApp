package com.adammendak.recipe.controller;

import com.adammendak.recipe.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    public final RecipeService recipeService;


    Logger logger = LoggerFactory.getLogger(IndexController.class);

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "", "/index"})
    public String getIndexPage(Model model) {

        logger.info("I'm in indexController");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
