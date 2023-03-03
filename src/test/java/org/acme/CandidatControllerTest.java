//package org.acme;
//
//import io.quarkus.test.junit.QuarkusTest;
//import org.acme.entity.Candidat;
//import org.acme.repository.CandidatRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.function.Executable;
//
//import javax.ws.rs.core.MediaType;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.jupiter.api.Assertions.*;
//
//@QuarkusTest
//public class CandidatControllerTest {
//    CandidatRepository candidatRepository;
//    @Test
//    public void testGetAllCandidats() {
//        Candidat candidat = given()
//                .when().get("/candidat/1")
//                .then()
//                .statusCode(200)
//                .extract().as(Candidat.class);
//
//        assertAll(
//                () -> assertNotNull(candidat),
//                () -> assertEquals("John", candidat.getNom_candidat()),
//                () -> assertEquals("Doe", candidat.getPrenom_candidat())
//        );
//    }
//
//    @Test
//    public void testGetCandidatById() {
//        // Create a candidat with id=1 for testing
//        Candidat candidat = new Candidat();
//        candidat.setId_candidat(1L);
//        candidat.setNom_candidat("John");
//        candidat.setPrenom_candidat("Doe");
//
//        // Persist the candidat using the repository
//         candidatRepository.persist(candidat);
//
//        // Send a GET request to /candidat/{id} with id=1
//        given()
//                .pathParam("id", 1)
//                .accept(MediaType.APPLICATION_JSON)
//                .when()
//                .get("/candidat/{id}")
//                .then()
//                .statusCode(200)
//                .body("id", equalTo(1))
//                .body("nom", is("John"))
//                .body("prenom", is("Doe"));
//    }
//
//
//}
