package F12.newsfeedproject.api.like.controller;

import F12.newsfeedproject.api.like.service.ApiLikeService;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiLikeController {

  private final ApiLikeService apiLikeService;

  @PostMapping("/board/{boardId}/like")
  public ResponseEntity<?> likeBoard(@PathVariable Long boardId,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    User user = userDetails.getUser();
    apiLikeService.createLikeBoard(user, boardId);

    return ResponseEntity.status(HttpStatus.CREATED).body("요청 성공");
  }

  @DeleteMapping("/board/{boardId}/like")
  public ResponseEntity<?> deleteLikeBoard(@PathVariable Long boardId,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    User user = userDetails.getUser();
    apiLikeService.deleteLikeBoard(user, boardId);

    return ResponseEntity.status(HttpStatus.CREATED).body("요청 성공");
  }

  @PostMapping("/comment/{commentId}/like")
  public ResponseEntity<?> likeComment(@PathVariable Long commentId) {

    return ResponseEntity.status(HttpStatus.CREATED).body("요청 성공");
  }

  @DeleteMapping("/comment/{boardId}/like")
  public ResponseEntity<?> deleteLikeComment(@PathVariable Long commentId) {

    return ResponseEntity.status(HttpStatus.CREATED).body("요청 성공");
  }

}
