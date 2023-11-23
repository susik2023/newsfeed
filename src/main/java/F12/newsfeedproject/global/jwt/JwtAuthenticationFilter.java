package F12.newsfeedproject.global.jwt;

import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.service.UserService;
import F12.newsfeedproject.global.exception.jwt.FailedAuthenticationException;
import F12.newsfeedproject.global.security.UserDetailsImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j(topic = "로그인 및 JWT 생성")
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final JwtManager jwtManager;

  private final UserService userService;

  private final ObjectMapper objectMapper;

  public JwtAuthenticationFilter(JwtManager jwtManager, UserService userService,
      ObjectMapper objectMapper) {
    this.jwtManager = jwtManager;
    this.userService = userService;
    this.objectMapper = objectMapper;
    setFilterProcessesUrl("/api/users/login");
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response)
      throws AuthenticationException {
    log.info("로그인 시도");

    UserLoginDto userLoginDto;
    try {
      userLoginDto = objectMapper.readValue(request.getInputStream(),
          UserLoginDto.class);

      return getAuthenticationManager().authenticate(
          new UsernamePasswordAuthenticationToken(
              userLoginDto.getUserName(),
              userLoginDto.getUserPassword(),
              null
          )
      );

    } catch (IOException e) {
      log.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain,
      Authentication authResult) {
    log.info("로그인 성공 및 JWT 생성");
    User loginUser = ((UserDetailsImpl) authResult.getPrincipal()).getUser();

    Long userId = loginUser.getUserId();
    String userName = loginUser.getUserName();

    String accessToken = jwtManager.createAccessToken(userName);
    String refreshToken = jwtManager.createRefreshToken(userName);

    saveRefreshToken(refreshToken, userId);

    response.setHeader("Access-Token", accessToken);
    response.setHeader("Refresh-Token", refreshToken);
  }

  private void saveRefreshToken(String refreshToken, Long userId) {
    userService.updateRefreshToken(refreshToken, userId);
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException failed) throws IOException, ServletException {
    throw new FailedAuthenticationException(failed);
  }
}
