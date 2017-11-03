package com.adammendak.recipe.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {

    Recipe recipe;

    @Before
    public void setUp() throws Exception {
        recipe = new Recipe();
    }

    @Test
    public void getDescription() throws Exception {
        String description = "aaa";
        recipe.setDescription("aaa");

        assertTrue(description.equals(recipe.getDescription()));
    }

    @Test
    public void getId() throws Exception {
        Long id =1l;
        recipe.setId(1l);

        assertEquals(id, recipe.getId());

    }

    @Test
    public void getDifficulty() throws Exception {
        recipe.setDifficulty(Difficulty.EASY);

        assertTrue(Difficulty.EASY == recipe.getDifficulty());

    }

}