package com.tui.order;

import static com.tui.order.OrderConstants.CLIENT;
import static com.tui.order.OrderConstants.DELIVERY_ADDRESS;
import static com.tui.order.OrderConstants.ORDER_TOTAL;
import static com.tui.order.OrderConstants.PILOTES;
import static com.tui.order.OrderConstants.UUID;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import com.github.javafaker.Faker;
import com.tui.address.AddressConstants;
import com.tui.client.ClientConstants;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrdersTests {
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

  private JSONObject createOrderJson(int pilotes, double total) {
    JSONObject client = new JSONObject();
    client.put(ClientConstants.FIRST_NAME, faker.name().firstName());
    client.put(ClientConstants.LAST_NAME, faker.name().lastName());
    client.put(ClientConstants.TELEPHONE, faker.phoneNumber().phoneNumber());

    JSONObject address = new JSONObject();
    address.put(AddressConstants.STREET, faker.address().streetName());
    address.put(
        AddressConstants.POSTCODE,
        faker.number().numberBetween(10, 999) + "-" + faker.number().numberBetween(10, 999));
    address.put(AddressConstants.CITY, faker.address().cityName());
    address.put(AddressConstants.COUNTRY, faker.country().name());

    JSONObject requestParams = new JSONObject();
    requestParams.put(OrderConstants.CLIENT, client);
    requestParams.put(OrderConstants.DELIVERY_ADDRESS, address);
    requestParams.put(PILOTES, pilotes);
    requestParams.put(OrderConstants.ORDER_TOTAL, total);
    return requestParams;
  }
}
