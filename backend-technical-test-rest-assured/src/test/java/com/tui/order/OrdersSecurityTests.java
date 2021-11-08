package com.tui.order;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersSecurityTests {

  public static final String VALID_TOKEN =
      "eyJhbGciOiJIUzUxMiJ9.eyJpc1ZhbGlkIjp0cnVlfQ.3sN4GFDnU7tYgLA_SxazOQQca1X3fTW4ColSxkP2XONZrzHMwc2AaRvxjPcV-Up51-eUsSV94BjEfh5wjnNtBQ";
  public static final String INVALID_TOKEN =
      "eyJhbGciOiJIUzUxMiJ9.eyJpc1ZhbGlkIjpmYWxzZX0.l0ZS55nKy5UKDF4bp6K4_QwfUquZeBmMPYmG9prEHwbdnO5H91HLne9Hx3bvKt_wxgJUxwIwSK8VxwQWXqzFvg";
  public static final String INVALID_FORMATTING_TOKEN = "broken";

  @DisplayName("Orders endpoint respond with bad request, with no credentials")
  @Test
  void getAllWhenEmptyCredentials() {
    when().get("/order").then().statusCode(SC_BAD_REQUEST);
  }

  @DisplayName("Orders endpoint should be available with valid token")
  @Test
  void getAllWithValidToken() {
    given()
        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
        .when()
        .get("/order")
        .then()
        .statusCode(SC_OK);
  }

  @DisplayName("Orders endpoint should be unauthorized with invalid token")
  @Test
  void getAllWithInValidToken() {
    given()
        .header(HttpHeaders.AUTHORIZATION, INVALID_TOKEN)
        .when()
        .get("/order")
        .then()
        .statusCode(SC_UNAUTHORIZED);
  }

  @DisplayName("Orders endpoint should be unauthorized with invalidly formatted token")
  @Test
  void getAllWithInValidFormattingToken() {
    given()
        .header(HttpHeaders.AUTHORIZATION, INVALID_FORMATTING_TOKEN)
        .when()
        .get("/order")
        .then()
        .statusCode(SC_UNAUTHORIZED);
  }
}
