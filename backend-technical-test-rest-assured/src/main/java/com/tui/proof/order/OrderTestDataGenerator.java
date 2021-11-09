package com.tui.proof.order;

import com.github.javafaker.Faker;
import com.tui.proof.address.AddressConstants;
import com.tui.proof.client.ClientConstants;
import net.minidev.json.JSONObject;

public class OrderTestDataGenerator {
  private OrderTestDataGenerator() {}

  private static Faker faker = new Faker();

  public static JSONObject updateOrderJson(String uuid, int pilotes, double total) {
    JSONObject order = createOrderJson(pilotes, total);
    order.put(OrderConstants.UUID, uuid);
    return order;
  }

  public static JSONObject createOrderJson(int pilotes, double total) {
    JSONObject client = new JSONObject();
    client.put(ClientConstants.FIRST_NAME, faker.name().firstName());
    client.put(ClientConstants.LAST_NAME, faker.name().lastName());
    client.put(ClientConstants.TELEPHONE, faker.phoneNumber().phoneNumber());

    JSONObject address = new JSONObject();
    address.put(AddressConstants.STREET, faker.address().streetName());
    address.put(
        AddressConstants.POSTCODE, faker.number().digits(2) + "-" + faker.number().digits(3));
    address.put(AddressConstants.CITY, faker.address().cityName());
    address.put(AddressConstants.COUNTRY, faker.country().name());

    JSONObject order = new JSONObject();
    order.put(OrderConstants.CLIENT, client);
    order.put(OrderConstants.DELIVERY_ADDRESS, address);
    order.put(OrderConstants.PILOTES, pilotes);
    order.put(OrderConstants.ORDER_TOTAL, total);
    return order;
  }

  public static JSONObject createOrderJson(String firstName, String lastName) {
    JSONObject client = new JSONObject();
    client.put(ClientConstants.FIRST_NAME, firstName);
    client.put(ClientConstants.LAST_NAME, lastName);
    client.put(ClientConstants.TELEPHONE, faker.phoneNumber().phoneNumber());

    JSONObject address = new JSONObject();
    address.put(AddressConstants.STREET, faker.address().streetName());
    address.put(
        AddressConstants.POSTCODE, faker.number().digits(2) + "-" + faker.number().digits(3));
    address.put(AddressConstants.CITY, faker.address().cityName());
    address.put(AddressConstants.COUNTRY, faker.country().name());

    JSONObject order = new JSONObject();
    order.put(OrderConstants.CLIENT, client);
    order.put(OrderConstants.DELIVERY_ADDRESS, address);
    order.put(OrderConstants.PILOTES, faker.number().numberBetween(1, 3) * 5);
    order.put(OrderConstants.ORDER_TOTAL, faker.number().digits(4));
    return order;
  }
}
