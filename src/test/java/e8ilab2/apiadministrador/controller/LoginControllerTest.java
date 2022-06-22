package e8ilab2.apiadministrador.controller;

import e8ilab2.apiadministrador.model.Administrador;
import e8ilab2.apiadministrador.security.Token;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LoginControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void should_create_token_when_adm_is_registered() {
        Token token = given()
                        .port(port)
                        .header("Content-type", "application/json")
                        .body(new Administrador("nome", "email@email.com", "senha"))
                        .and()
                    .when()
                        .post("/login")
                    .then()
                        .statusCode(HttpStatus.OK.value())
                        .extract().as(Token.class);

        assertNotNull(token.getToken());
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