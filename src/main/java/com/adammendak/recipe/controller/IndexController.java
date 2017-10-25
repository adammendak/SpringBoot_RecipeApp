package com.adammendak.recipe.controller;

import com.adammendak.recipe.model.Category;
import com.adammendak.recipe.model.UnitOfMeasure;
import com.adammendak.recipe.repository.CategoryRepository;
import com.adammendak.recipe.repository.RecipeRepository;
import com.adammendak.recipe.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"/", "", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("Fast Food");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUom("gram");

        System.out.println("Cat id is :" + categoryOptional.get().getId());
        System.out.println("Uom id is :" + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
