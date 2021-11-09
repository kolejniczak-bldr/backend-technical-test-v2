package com.tui.proof.order;

import static com.tui.proof.order.OrderConstants.CLIENT;
import static com.tui.proof.order.OrderConstants.DELIVERY_ADDRESS;
import static com.tui.proof.order.OrderConstants.ORDER_TOTAL;
import static com.tui.proof.order.OrderConstants.PILOTES;
import static com.tui.proof.order.OrderConstants.UUID;
import static com.tui.proof.order.OrderTestDataGenerator.createOrderJson;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrdersCreationTests {
  Faker faker = new Faker();

  @DisplayName("Should create an order")
  @Test
  void create() {
    JSONObject requestParams = createOrderJson(5, 5);

    String body = requestParams.toJSONString();
    given()
        .contentType(ContentType.JSON)
        .body(body)
        .when()
        .post("/order")
        .then()
        .statusCode(HttpStatus.SC_CREATED)
        .body(CLIENT, notNullValue())
        .body(DELIVERY_ADDRESS, notNullValue())
        .body(PILOTES, notNullValue())
        .body(ORDER_TOTAL, notNullValue())
        .body(UUID, notNullValue());
  }

  @DisplayName("Positive pilotes amount validation")
  @ParameterizedTest(name = "Should allow {0} pilotes")
  @ValueSource(ints = {5, 10, 15})
  void pilotesPositiveValidation(int input) {
    JSONObject requestParams = createOrderJson(input, input);

    String body = requestParams.toJSONString();
    given()
        .contentType(ContentType.JSON)
        .body(body)
        .when()
        .post("/order")
        .then()
        .statusCode(HttpStatus.SC_CREATED)
        .body(UUID, notNullValue())
        .body(CLIENT, notNullValue())
        .body(DELIVERY_ADDRESS, notNullValue())
        .body(PILOTES, notNullValue())
        .body(PILOTES, equalTo(input))
        .body(ORDER_TOTAL, notNullValue())
        .body(ORDER_TOTAL, equalTo(input + 0f));
  }

  @DisplayName("Negative pilotes amount validation")
  @ParameterizedTest(name = "Should not allow {0} pilotes")
  @ValueSource(ints = {-1, 0, 4, 6, 9, 11, 14, 16})
  void pilotesNegativeValidation(int input) {
    JSONObject requestParams = createOrderJson(input, input);

    String body = requestParams.toJSONString();
    given()
        .contentType(ContentType.JSON)
        .body(body)
        .when()
        .post("/order")
        .then()
        .statusCode(HttpStatus.SC_BAD_REQUEST)
        .body(UUID, nullValue())
        .body(CLIENT, nullValue())
        .body(DELIVERY_ADDRESS, nullValue())
        .body(PILOTES, equalTo("Wrong number of pilotes, only 5, 10, or 15 allowed"));
  }
}
