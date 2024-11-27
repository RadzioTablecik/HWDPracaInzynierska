package com.example.hwdpracainzynierska.RESTAssured.e2e;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RouletteControllerTest {
    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void shouldGetCurrentRandNumber() {
        RestAssured.given()
                .when()
                .get("/roulette/prng")
                .then()
                .statusCode(200)
                .body("game", equalTo("Roulette"))
                .body("generatedNumber", lessThan(37));
    }

    @Test
    public void shouldBeForbiddenWithoutAuth(){
        RestAssured.given()
                .auth().none()
                .when()
                .post("/roulette")
                .then()
                .statusCode(403);
    }

    @Test
    public void shouldLoginAndPlay(){
        String token = getToken();

        Response gameResult = given()
                .header("Authorization", "Bearer " + token)
                .body("""
                            {
                             "betType":"RedBlack",
                             "betVersion":"1"
                            }
                         """
                )
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .post("/roulette")
                .then()
                .statusCode(200)
                .body("game", equalTo("Roulette"))
                .body("userId", notNullValue())
                .body("betType", equalTo("RedBlack"))
                .body("generatedNumber", notNullValue())
                .body("betVersion", equalTo(1))
                .body("result", notNullValue())
                .extract()
                .response();

        System.out.println(gameResult.asPrettyString());
    }

    public static String getJsonPath(Response response, String key) {
        String complete = response.asString();
        JsonPath js = new JsonPath(complete);
        return js.get(key).toString();
    }

    //use only if user exists
    public static String getToken(){
        Response authToken = given().contentType(ContentType.JSON)
                .body("""
                            {
                             "email":"kpiech70@gmail.com",
                             "password":"Jakub21"
                            }
                         """
                )
                .when()
                .post("/api/v1/auth/authenticate")
                .then()
                .extract()
                .response();
        return getJsonPath(authToken, "token");
    }


}
