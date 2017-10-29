package com.adammendak.recipe.service;

import com.adammendak.recipe.model.Category;
import com.adammendak.recipe.repository.CategoryRepository;

import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getCategory() {

        return categoryRepository.findAll();
    }

    @Override
    public Category findByDescription(String description) {

        return categoryRepository.findByDescription(description);

    }
}
