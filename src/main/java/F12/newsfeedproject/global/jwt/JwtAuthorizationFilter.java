package F12.newsfeedproject.global.jwt;

import F12.newsfeedproject.global.exception.jwt.FailedAuthenticationException;
import F12.newsfeedproject.global.exception.jwt.NoJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j(topic = "JWT 검증 및 인가")
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

  private static final String[] WHITE_LIST = {"/api/users/signup", "/api/users/login"};

  private final JwtManager jwtManager;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
      FilterChain filterChain) throws ServletException, IOException {

    String jwt = JwtUtil.getTokenFromRequest(req);

    if (jwt == null && !isWhiteListUrl(req.getRequestURL())){
      throw new NoJwtException();
    }

    if (jwt != null) {
      jwtManager.validateToken(jwt);

      String memberName = jwtManager.getUserNameFromToken(jwt);

      try {
        setAuthentication(memberName);
      } catch (UsernameNotFoundException e) {
        throw new FailedAuthenticationException(e);
      }
    }

    filterChain.doFilter(req, res);
  }

  public void setAuthentication(String username) {

    SecurityContext context = SecurityContextHolder.createEmptyContext();
    Authentication authentication = createAuthentication(username);
    context.setAuthentication(authentication);

    SecurityContextHolder.setContext(context);
  }

  private Authentication createAuthentication(String username) {

    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
  }

  private static boolean isWhiteListUrl(StringBuffer requestUrlBuffer) {

    String requestUrl = requestUrlBuffer.toString();
    for (String whiteUrl : WHITE_LIST) {
      if (requestUrl.contains(whiteUrl)) {
        return true;
      }
    }
    return false;
  }
}
