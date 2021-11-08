package com.tui.proof.order;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PilotesValidator implements ConstraintValidator<PilotesValidation, Integer> {
  private static final List<Integer> possiblePilotesOrder = List.of(5, 10, 15);

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    return possiblePilotesOrder.contains(value);
  }
}
