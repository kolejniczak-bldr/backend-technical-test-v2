package com.tui.proof.order;

import com.tui.proof.order.request.OrderCreateRequest;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrderValidator implements ConstraintValidator<OrderValidation, OrderCreateRequest> {
  private static final List<Integer> possiblePilotesOrder = List.of(5, 10, 15);

  @Override
  public boolean isValid(OrderCreateRequest value, ConstraintValidatorContext context) {
    return possiblePilotesOrder.contains(value.getPilotes());
  }
}
