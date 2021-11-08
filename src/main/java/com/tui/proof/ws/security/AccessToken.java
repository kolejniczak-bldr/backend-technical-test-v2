package com.tui.proof.ws.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccessToken {
  private final String token;

  @JsonIgnore
  public boolean isValid() {
    return JWTParser.checkToken(token);
  }
}
