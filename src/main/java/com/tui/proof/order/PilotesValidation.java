package com.tui.proof.order;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PilotesValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PilotesValidation {
  String message() default "Wrong number of pilotes, only 5, 10, or 15 allowed";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
