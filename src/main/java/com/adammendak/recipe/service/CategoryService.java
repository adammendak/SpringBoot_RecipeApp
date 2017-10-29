package com.adammendak.recipe.service;

import com.adammendak.recipe.model.Category;

import java.util.Set;

public interface CategoryService {

    Set<Category> getCategory();

    Category findByDescription (String description);


}

