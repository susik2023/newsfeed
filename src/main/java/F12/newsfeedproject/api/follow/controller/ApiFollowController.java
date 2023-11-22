package F12.newsfeedproject.api.follow.controller;

import F12.newsfeedproject.domain.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/follow")
public class ApiFollowController {

    private final FollowService followService;

    @PostMapping("/{followerId}")
    public ResponseEntity<?> follow(
        @PathVariable Long followerId) {

        // security에서 꺼낸 유저 지금은 임시
        Long userId = 1L;

        followService.followOrUnFollowUser(userId, followerId);
        return ResponseEntity.status(HttpStatus.OK).body("요청 성공");
    }

}
