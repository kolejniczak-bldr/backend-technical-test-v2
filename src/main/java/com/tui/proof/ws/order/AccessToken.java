package com.tui.proof.ws.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tui.proof.ws.JWTParser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccessToken {
  private final String token;

  @JsonIgnore
  public boolean isValid() {
    return JWTParser.checkToken(token);
  }
}
