package com.adammendak.recipe.service;

import com.adammendak.recipe.model.Category;
import com.adammendak.recipe.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    @Override
    public Set<Category> getCategory() {

        logger.debug("I'm in categoryServiceImpl");
        return categoryRepository.findAll();
    }

    @Override
    public Category findByDescription(String description) {

        return categoryRepository.findByDescription(description);

    }
}
