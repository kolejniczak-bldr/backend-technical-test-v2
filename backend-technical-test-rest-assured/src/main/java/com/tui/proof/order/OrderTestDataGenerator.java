package com.tui.proof.order;

import static com.tui.proof.order.OrderConstants.PILOTES;

import com.github.javafaker.Faker;
import com.tui.proof.address.AddressConstants;
import com.tui.proof.client.ClientConstants;
import net.minidev.json.JSONObject;

public class OrderTestDataGenerator {
  private static Faker faker = new Faker();

  public static JSONObject createOrderJson(int pilotes, double total) {
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
