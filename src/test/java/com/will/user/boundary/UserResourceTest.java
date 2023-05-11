package com.will.user.boundary;

import com.will.user.control.UserController;
import com.will.user.control.UserRepository;
import com.will.user.entity.User;
import com.will.user.entity.UserRequest;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestHTTPEndpoint(UserResource.class)
public class UserResourceTest {

    @Test
    @DisplayName("Should create an user successfully")
    @Order(1)
    public void createUserTest(){
        var userRequest = new UserRequest();
        userRequest.setName("foo");
        userRequest.setEmail("foo.bar@foobar.foo");
        userRequest.setCellphoneNumber("12345678");

        Response response = given()
                .contentType(ContentType.JSON).body(JsonbBuilder.create().toJson(userRequest))
                .when()
                .post()
                .then()
                .extract().response();

        assertEquals(201, response.statusCode());
    }

    @Test
    @DisplayName("Should return all users created")
    @Order(3)
    public void listUsers(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("size()", Matchers.greaterThanOrEqualTo(1));
    }

    @Test
    @DisplayName("Should return 204, user updated")
    @Order(4)
    public void updateUser(){
        var userRequest = new UserRequest();
        userRequest.setName("fooUpdated");
        userRequest.setEmail("fooUpdated.bar@foobar.foo");
        userRequest.setCellphoneNumber("87654321");

        given()
                .contentType(ContentType.JSON)
                .body(JsonbBuilder.create().toJson(userRequest))
                .when()
                .put("/1")
                .then().statusCode(200).body("size()", Matchers.greaterThanOrEqualTo(1));;
    }

    @Test
    @DisplayName("Should return 204, user deleted")
    @Order(5)
    public void deleteUser(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/1")
                .then().statusCode(204);
    }

}
