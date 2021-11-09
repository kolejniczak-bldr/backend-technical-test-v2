package com.tui.proof.order;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

import com.tui.proof.jwt.TokenConstants;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Order - Checking endpoint security")
class OrdersSecurityTests {

  @DisplayName("Orders endpoint respond with bad request, with no credentials")
  @Test
  void getAllWhenEmptyCredentials() {
    when().get("/order").then().statusCode(SC_BAD_REQUEST);
  }

  @DisplayName("Orders endpoint should be available with valid token")
  @Test
  void getAllWithValidToken() {
    given()
        .header(HttpHeaders.AUTHORIZATION, TokenConstants.VALID_TOKEN)
        .when()
        .get("/order")
        .then()
        .statusCode(SC_OK);
  }

  @DisplayName("Orders endpoint should be unauthorized with invalid token")
  @Test
  void getAllWithInValidToken() {
    given()
        .header(HttpHeaders.AUTHORIZATION, TokenConstants.INVALID_TOKEN)
        .when()
        .get("/order")
        .then()
        .statusCode(SC_UNAUTHORIZED);
  }

  @DisplayName("Orders endpoint should be unauthorized with invalidly formatted token")
  @Test
  void getAllWithInValidFormattingToken() {
    given()
        .header(HttpHeaders.AUTHORIZATION, TokenConstants.INVALID_FORMATTING_TOKEN)
        .when()
        .get("/order")
        .then()
        .statusCode(SC_UNAUTHORIZED);
  }
}
