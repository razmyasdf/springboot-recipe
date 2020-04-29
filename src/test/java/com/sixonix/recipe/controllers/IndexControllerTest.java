package com.sixonix.recipe.controllers;

import com.sixonix.recipe.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

    IndexController indexController;
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    @BeforeEach
    void setUp(){
       // MockitoAnnotations.initMocks(recipeService);
        //MockitoAnnotations.initMocks(model);
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void mockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void getIndexPage() {

        String value = indexController.getIndexPage(model);
        assertEquals("index",value);
        verify(recipeService,times(1)).getRecipes(); //verify that called 1 time
        verify(model,times(1)).addAttribute(eq("recipes"),anySet());
    }
}