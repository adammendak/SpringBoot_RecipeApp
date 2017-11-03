package com.adammendak.recipe.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {

        Long idValue = 4l;
        category.setId(4l);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception {

        String description = "abcd";
        category.setDescription("abcd");

        assertTrue(description.equals(category.getDescription()));
    }

    @Test
    public void getRecipes() throws Exception {

        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());
        recipeSet.add(new Recipe());
        recipeSet.add(new Recipe());


        category.setRecipes(recipeSet);

        assertNotNull(category.getRecipes());

    }

}