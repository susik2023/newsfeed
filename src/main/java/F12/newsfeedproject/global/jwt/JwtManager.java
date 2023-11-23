package F12.newsfeedproject.global.jwt;

import F12.newsfeedproject.global.exception.jwt.ExpiredJwtTokenException;
import F12.newsfeedproject.global.exception.jwt.InvalidJwtSignatureException;
import F12.newsfeedproject.global.exception.jwt.InvalidJwtTokenException;
import F12.newsfeedproject.global.exception.jwt.UnsupportedJwtTokenException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtManager {

  private final long accessTime;
  private final long refreshTime;
  private final Key key;
  private final String issuer;

  public JwtManager(@Value("${jwt.token.issuer}") String issuer,
      @Value("${jwt.token.secret}") String secret,
      @Value("${jwt.token.access-time}") long accessTime,
      @Value("${jwt.token.refresh-time}") long refreshTime) {

    byte[] keyBytes = Decoders.BASE64.decode(secret);
    this.key = Keys.hmacShaKeyFor(keyBytes);
    this.issuer = issuer;
    this.accessTime = accessTime;
    this.refreshTime = refreshTime;
  }

  public String createAccessToken(String userName) {
    long nowTime = new Date().getTime();
    Date issuedAt = new Date();
    Date expiration = new Date(nowTime + accessTime);

    return Jwts.builder()
        .setIssuer(issuer)
        .setSubject(userName)
        .setAudience(TokenType.ACCESS.toString())
        .setExpiration(expiration)
        .setIssuedAt(issuedAt)
        .signWith(key, SignatureAlgorithm.HS512)
        .compact();
  }

  public String createRefreshToken(String userName) {
    long nowTime = new Date().getTime();
    Date issuedAt = new Date();
    Date expiration = new Date(nowTime + refreshTime);

    return Jwts.builder()
        .setIssuer(issuer)
        .setSubject(userName)
        .setAudience(TokenType.REFRESH.toString())
        .setExpiration(expiration)
        .setIssuedAt(issuedAt)
        .signWith(key, SignatureAlgorithm.HS512)
        .compact();
  }

  public String getUserNameFromToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody()
        .getSubject();
  }

  public String getTokenTypeFromToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody()
        .getAudience();
  }

  public void validateToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    } catch (SecurityException | MalformedJwtException e) {
      throw new InvalidJwtSignatureException(e);
    } catch (ExpiredJwtException e) {
      throw new ExpiredJwtTokenException(e);
    } catch (UnsupportedJwtException e) {
      throw new UnsupportedJwtTokenException(e);
    } catch (IllegalArgumentException e) {
      throw new InvalidJwtTokenException(e);
    }
  }
}
