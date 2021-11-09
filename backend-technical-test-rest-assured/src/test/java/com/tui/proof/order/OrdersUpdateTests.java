package com.tui.proof.order;

import static com.tui.proof.order.OrderTestDataGenerator.createOrderJson;
import static com.tui.proof.order.OrderTestDataGenerator.updateOrderJson;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Order - Testing updates")
class OrdersUpdateTests {

  @DisplayName("Should update Order within the 5 minutes")
  @Test
  void update() {
    JSONObject orderJson = createOrderJson(5, 5);

    String body = orderJson.toJSONString();
    Response response =
        given()
            .contentType(ContentType.JSON)
            .body(body)
            .when()
            .post("/order")
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .response();
    java.util.UUID uuid = response.jsonPath().getUUID("uuid");

    JSONObject updatedOrder = updateOrderJson(uuid.toString(), 15, 15);
    given()
        .contentType(ContentType.JSON)
        .body(updatedOrder.toJSONString())
        .when()
        .put("/order")
        .then()
        .statusCode(HttpStatus.SC_NO_CONTENT);
  }
}
