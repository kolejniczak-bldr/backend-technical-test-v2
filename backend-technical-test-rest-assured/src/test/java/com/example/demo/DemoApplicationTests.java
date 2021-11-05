package com.example.demo;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class DemoApplicationTests {

  @Test
  void test() {
    when().get("/").then().statusCode(200).body(equalTo("Hello"));
  }
}
