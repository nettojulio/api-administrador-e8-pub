package e8ilab2.apiadministrador.controller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import e8ilab2.apiadministrador.model.Administrador;
import e8ilab2.apiadministrador.security.Token;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@Sql("/schema.sql")
class ValidarControllerTest {

	@LocalServerPort
	private int port;

	Token token;

	private Token gerarToken() {
		return
				given()
					.port(port)
					.header("Content-type", "application/json")
					.body(new Administrador("nome", "email@email.com", "senha"))
					.and()
				.when()
					.post("/login")
				.then()
					.statusCode(HttpStatus.OK.value())
					.extract().as(Token.class);
	}

	@Test
	void should_validate_test() {
		given()
			.port(port)
			.header("Content-type", "application/json")
			.header("Authorization", gerarToken().getToken())
		.when()
			.get("/validar")
		.then()
				.statusCode(HttpStatus.NO_CONTENT.value());
	}

	@Test
	void should_return_unauthorized_when_no_token() {
		given()
				.port(port)
				.header("Content-type", "application/json")
				.header("Authorization", "")
				.when()
				.get("/validar")
				.then()
				.statusCode(HttpStatus.UNAUTHORIZED.value());
	}
}
