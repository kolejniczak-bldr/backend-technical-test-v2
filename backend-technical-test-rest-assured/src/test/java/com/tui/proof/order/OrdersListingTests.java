package com.tui.proof.order;

import static com.tui.proof.order.OrderTestDataGenerator.createOrderJson;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

import com.tui.proof.jwt.TokenConstants;
import io.restassured.http.ContentType;
import java.time.Instant;
import net.minidev.json.JSONObject;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Order - Testing listing filtering")
class OrderListingTests {
  private static long testDataIdentifier;

  @BeforeAll
  static void beforeAll() {
    testDataIdentifier = Instant.now().getEpochSecond();
    createTestOrder("Lorem", "Ipsum");
    createTestOrder("Dolor", "Sit");
    createTestOrder("Amet", "Foo");
    createTestOrder("Lorem", "Sit");
  }

  @DisplayName("Should return all orders without search term")
  @Disabled("There is no data cleaning endpoints as of now")
  @Test
  void findAll() {
    given()
        .header(HttpHeaders.AUTHORIZATION, TokenConstants.VALID_TOKEN)
        .when()
        .get("/order")
        .then()
        .statusCode(SC_OK)
        .body("size()", is(4));
  }

  @DisplayName("Should match on both first and last name, all the test data")
  @Test
  void findAllTestedNow() {
    given()
        .header(HttpHeaders.AUTHORIZATION, TokenConstants.VALID_TOKEN)
        .param("search", testDataIdentifier)
        .when()
        .get("/order")
        .then()
        .statusCode(SC_OK)
        .body("size()", is(4));
  }

  @DisplayName("Should match on both first and last name, some of the data")
  @Test
  void getAllWithMatchInFirstAndLastName() {
    given()
        .header(HttpHeaders.AUTHORIZATION, TokenConstants.VALID_TOKEN)
        .param("search", testDataIdentifier + "Lorem")
        .when()
        .get("/order")
        .then()
        .statusCode(SC_OK)
        .body("size()", is(2));
  }

  private static void createTestOrder(String firstName, String lastNAme) {
    JSONObject order =
        createOrderJson(testDataIdentifier + firstName, testDataIdentifier + lastNAme);
    given()
        .contentType(ContentType.JSON)
        .body(order.toJSONString())
        .when()
        .post("/order")
        .then()
        .statusCode(HttpStatus.SC_CREATED);
  }
}
