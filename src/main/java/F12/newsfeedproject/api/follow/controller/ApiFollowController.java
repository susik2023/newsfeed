package F12.newsfeedproject.api.follow.controller;

import F12.newsfeedproject.api.follow.service.ApiFollowService;
import F12.newsfeedproject.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/follow")
public class ApiFollowController {

  private final ApiFollowService apiFollowService;

  /**
   * 팔로우 하기
   * @param userDetails
   * @param followerId
   * @return
   */
  @PostMapping("/{followerId}")
  public ResponseEntity<?> followUser(
      @AuthenticationPrincipal UserDetailsImpl userDetails,
      @PathVariable Long followerId) {

    String username = userDetails.getUsername();

    apiFollowService.followUser(username, followerId);
    return ResponseEntity.status(HttpStatus.OK).body("요청 성공");
  }

  /**
   * 팔로우 취소
   * @param followerId
   * @return
   */
  @DeleteMapping("/{followerId}")
  public ResponseEntity<?> unFollowUser(
      @AuthenticationPrincipal UserDetailsImpl userDetails,
      @PathVariable Long followerId) {
    String username = userDetails.getUsername();

    apiFollowService.unFollowUser(username, followerId);
    return ResponseEntity.status(HttpStatus.OK).body("요청 성공");
  }

}
