package F12.newsfeedproject.api.user.controller;

import F12.newsfeedproject.api.user.dto.request.UserModifyRequestDTO;
import F12.newsfeedproject.api.user.dto.request.UserSignupRequestDTO;
import F12.newsfeedproject.api.user.dto.response.UserResponseDTO;
import F12.newsfeedproject.api.user.service.ApiUserService;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.global.exception.member.UnAuthorizedModifyException;
import F12.newsfeedproject.global.jwt.JwtUtil;
import F12.newsfeedproject.global.security.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class ApiUserController {

  private final ApiUserService apiUserService;

  @PostMapping("/signup")
  public ResponseEntity<?> signupUser(
      @Valid @RequestBody UserSignupRequestDTO userSignupRequestDTO) {

    UserResponseDTO userSignupResponseDTO = apiUserService.signupUser(userSignupRequestDTO);

    return ResponseEntity.ok(userSignupResponseDTO);
  }

  @PatchMapping("/{userId}")
  public ResponseEntity<?> updateUser(
      @AuthenticationPrincipal UserDetailsImpl userDetails,
      @PathVariable Long userId,
      @Valid @RequestBody UserModifyRequestDTO userModifyRequestDTO) {

    if (!haveModifyAuthorization(userDetails.getUser(), userId)) {
      throw new UnAuthorizedModifyException();
    }

    UserResponseDTO userModifyResponseDTO = apiUserService.updateUser(userModifyRequestDTO, userId);

    return ResponseEntity.ok(userModifyResponseDTO);
  }

  private boolean haveModifyAuthorization(User loginUser, Long modifiedUserId) {
    return loginUser.getUserId() == modifiedUserId;

  }

  @GetMapping("/reissue")
  public ResponseEntity<?> reissueAccessToken(HttpServletRequest req, HttpServletResponse rep) {

    String refreshToken = JwtUtil.getTokenFromRequest(req);
    String accessToken = apiUserService.reissueAccessToken(refreshToken);

    rep.setHeader("Access-Token", accessToken);

    return ResponseEntity.ok("요청 성공");
  }

  @GetMapping("/logout")
  public ResponseEntity<?> logoutUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {

    User findUser = userDetails.getUser();
    apiUserService.logoutUser(findUser.getUserId());

    return ResponseEntity.ok("요청 성공");
  }


}
