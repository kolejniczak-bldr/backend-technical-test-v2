package com.tui.proof.ws;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public final class JWTParser {
  static final String IS_VALID = "isValid";
  private static final String SECRET_KEY = "dummySecretKey";

  private JWTParser() {}

  static Claims decryptToken(String jwtToken) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();
  }

  public static boolean checkToken(String jwtToken) {
    try {
      decryptToken(jwtToken);
    } catch (MalformedJwtException | SignatureException ex) {
      return false;
    }
    return isValid(jwtToken);
  }

  private static boolean isValid(String jwtToken) {
    Claims decryptedToken = decryptToken(jwtToken);
    return decryptedToken.get(IS_VALID, Boolean.class);
  }
}
