package F12.newsfeedproject.api.follow.controller;

import F12.newsfeedproject.api.follow.service.ApiFollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/follow")
public class ApiFollowController {

    private final ApiFollowService apiFollowService;

    @GetMapping("/{followerId}")
    public ResponseEntity<?> followUser(
        @PathVariable Long followerId) {

        // security에서 꺼낸 유저 지금은 임시
        String username = "test1";

        apiFollowService.followUser(username, followerId);
        return ResponseEntity.status(HttpStatus.OK).body("요청 성공");
    }

    @DeleteMapping("/{followerId}")
    public ResponseEntity<?> unFollowUser(
        @PathVariable Long followerId) {

        // security에서 꺼낸 유저 지금은 임시
        String username = "test1";

        apiFollowService.unFollowUser(username, followerId);
        return ResponseEntity.status(HttpStatus.OK).body("요청 성공");
    }

}
