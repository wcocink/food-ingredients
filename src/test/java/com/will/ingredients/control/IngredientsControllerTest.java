package com.will.ingredients.control;

import com.will.ingredients.entity.IngredientRequest;
import com.will.user.entity.UserRequest;
import com.will.user.entity.UserResponse;
import com.will.user.exceptions.UserException;
import com.will.user.exceptions.UserExceptionCode;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IngredientsControllerTest {

    @Inject
    IngredientController ingredientController;

    @Test
    @DisplayName("Should create an ingredient successfully")
    @Order(1)
    public void create_Ingredient_Test(){
        Response response = ingredientController.createIngredient(new IngredientRequest("Test", 200.0));
        assertEquals(201,response.getStatus());
    }

    @Test
    @DisplayName("Should list all ingredients successfully")
    @Order(2)
    public void list_Ingredients_Test(){
        var ingredients = ingredientController.listIngredients();
        assertEquals(1, ingredients.size());
    }
//
//    @Test
//    @DisplayName("Should update an ingredient")
//    @Order(4)
//    public void update_User(){
//        Response response = ingredientController.updateIngredient(1L, new UserRequest("Test2", "test@test2.test","1234555"));
//        assertEquals(200,response.getStatus());
//        assertEquals(UserResponse.class, response.getEntity().getClass());
//        assertEquals("UserResponse{name='Test2', email='test@test2.test', cellphoneNumber='1234555'}", response.getEntity().toString());
//    }

}
