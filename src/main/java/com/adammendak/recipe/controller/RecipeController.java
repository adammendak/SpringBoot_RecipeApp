package com.adammendak.recipe.controller;
import com.adammendak.recipe.model.Recipe;
import com.adammendak.recipe.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipeController {

    public final RecipeService recipeService;

    Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/recipe/{id}/show", method = RequestMethod.GET)
    public String getById(@PathVariable String id, Model model) {

        logger.info("going into recipe no " + id);
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    @RequestMapping(value = "/recipe/{id}/update", method = RequestMethod.GET)
    public String updateRecipe(@PathVariable String id, Model model) {

        logger.info("updating recipe no:" + id);
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/recipeForm";
    }

    @RequestMapping(value = "/recipe/new", method = RequestMethod.GET)
    public String getRecipeForm(Model model){
        model.addAttribute("recipe", new Recipe());
        return  "recipe/recipeForm";
    }

    @RequestMapping(value = "/recipe/new", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute Recipe recipe) {
        Recipe savedRecipe = recipeService.saveRecipe(recipe);

        return "redirect:/recipe/" + savedRecipe.getId() + "/show";
    }

    @RequestMapping(value = "/recipe/{id}/delete", method = RequestMethod.GET)
    public String deleteRecipe(@PathVariable String id) {
        logger.info("deleting Recipe wih id:" + id);
        recipeService.detedeRecipe(new Long(id));
        return "redirect:/";
    }
}
