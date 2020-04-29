package com.sixonix.recipe.service;

import com.sixonix.recipe.models.Recipe;
import com.sixonix.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Set<Recipe> recipes = recipeService.getRecipes();
    }

    @Test
    void getRecipesWithValue(){
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll(); // verify that recipeRepository is called 1 time only
    }
}