package F12.newsfeedproject.global.jwt;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorResponse;
import F12.newsfeedproject.global.exception.jwt.ExpiredJwtTokenException;
import F12.newsfeedproject.global.exception.jwt.FailedAuthenticationException;
import F12.newsfeedproject.global.exception.jwt.InvalidJwtSignatureException;
import F12.newsfeedproject.global.exception.jwt.InvalidJwtTokenException;
import F12.newsfeedproject.global.exception.jwt.NoJwtException;
import F12.newsfeedproject.global.exception.jwt.UnsupportedJwtTokenException;
import F12.newsfeedproject.global.util.StackTracePrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@RequiredArgsConstructor
public class ExceptionHandlerFilter extends OncePerRequestFilter {

  private final ObjectMapper objectMapper;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain)
      throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (InvalidJwtSignatureException | ExpiredJwtTokenException | UnsupportedJwtTokenException
        | InvalidJwtTokenException | FailedAuthenticationException | NoJwtException e) {
      sendErrorMessage(response, e);
    }
  }

  private void sendErrorMessage(HttpServletResponse response, BusinessException e)
      throws IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    response.setStatus(e.getStatus());
    response.getWriter().write(objectMapper.writeValueAsString(
        ErrorResponse.of(HttpStatus.valueOf(e.getStatus()), e.getMessage())));

    log.error(StackTracePrinter.getPrintStackTrace(e));
  }
}
