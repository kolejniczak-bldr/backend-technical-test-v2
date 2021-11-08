package com.tui.order;

import static io.restassured.RestAssured.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTests {

  @DisplayName("Check endpoint availability, with no credentials")
  @Test
  void getAllWhenEmpty() {
    when().get("/order").then().statusCode(401);
  }
}
