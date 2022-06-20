package e8ilab2.apiadministrador.controller;

import e8ilab2.apiadministrador.model.Administrador;
import e8ilab2.apiadministrador.security.Token;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AdministradorControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void should_create_adm() {
            given()
                .port(port)
                .header("Content-type", "application/json")
                .body(new Administrador("nome", "email@email.com", "senha"))
                .and()
            .when()
                .post("/admin")
            .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    void should_return_unauthorized_when_adm_is_not_registered() {
        given()
            .port(port)
            .header("Content-type", "application/json")
            .body(new Administrador("notfound", "notfound@email.com", "senha"))
            .and()
        .when()
            .post("/login")
        .then()
            .statusCode(HttpStatus.UNAUTHORIZED.value());
    }
}