package com.tui.order;

import static com.tui.jwt.TokenConstants.VALID_TOKEN;
import static io.restassured.RestAssured.given;

import com.github.javafaker.Faker;
import com.tui.address.AddressConstants;
import com.tui.client.ClientConstants;
import net.minidev.json.JSONObject;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTests {
  Faker faker = new Faker();

  @DisplayName("Should create an order")
  @Test
  void getAllWithValidToken() {
    JSONObject requestParams = createOrderJson();

    String body = requestParams.toJSONString();
    given().body(body).when().post("/order").then().statusCode(HttpStatus.SC_CREATED);

    given()
        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
        .body(body)
        .when()
        .get("/order")
        .then()
        .statusCode(HttpStatus.SC_OK);
  }

  private JSONObject createOrderJson() {
    JSONObject client = new JSONObject();
    client.put(ClientConstants.FIRST_NAME, faker.name().firstName());
    client.put(ClientConstants.LAST_NAME, faker.name().lastName());
    client.put(ClientConstants.TELEPHONE, faker.phoneNumber().phoneNumber());

    JSONObject address = new JSONObject();
    address.put(AddressConstants.STREET, faker.address().streetName());
    address.put(AddressConstants.POSTCODE, faker.address().zipCode());
    address.put(AddressConstants.CITY, faker.address().cityName());
    address.put(AddressConstants.COUNTRY, faker.country().name());

    JSONObject requestParams = new JSONObject();
    requestParams.put(OrderConstants.CLIENT, client);
    requestParams.put(OrderConstants.DELIVERY_ADDRESS, address);
    requestParams.put(OrderConstants.PILOTES, 5);
    requestParams.put(OrderConstants.ORDER_TOTAL, 5);
    return requestParams;
  }
}
