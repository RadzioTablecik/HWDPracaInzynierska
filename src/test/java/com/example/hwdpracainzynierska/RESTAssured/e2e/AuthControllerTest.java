package com.example.hwdpracainzynierska.RESTAssured.e2e;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;


import java.time.Instant;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthControllerTest {
    private static String email;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        long timestamp = Instant.now().toEpochMilli();
        email = "kpiech" + timestamp + "@gmail.com";
    }

    @Test
    @Order(1)
    public void shouldRegisterAndGetToken() {
            given().contentType(ContentType.JSON)
                .body("""
                            {
                             "firstname" : "Jakub",
                             "email":"%s",
                             "password":"Jakub21"
                            }
                         """.formatted(email)
                )
                .when()
                    .post("/api/v1/auth/register")
                .then()
                    .statusCode(200)
                    .body("token", notNullValue());
    }

    @Test
    @Order(2)
    public void shouldLoginAndGetToken() {
        Response authToken = given().contentType(ContentType.JSON)
                .body("""
                            {
                             "email":"%s",
                             "password":"Jakub21"
                            }
                         """.formatted(email)
                )
                .when()
                .post("/api/v1/auth/authenticate")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();
    }

}
