package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CandidatControllerTest {

    @Test
    public void testGetAllEndpoint() {
        given()
                .when().get("/candidat")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

}
