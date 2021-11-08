package com.tui.proof.ws;

import com.tui.proof.ws.security.InvalidTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalControllerValidationAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(InvalidTokenException.class)
  protected static ResponseEntity<Object> handleInvalidTokenException(InvalidTokenException e) {
    log.info(e.getMessage());
    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  }
}
