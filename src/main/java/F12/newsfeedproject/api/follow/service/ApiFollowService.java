package F12.newsfeedproject.api.follow.service;

import F12.newsfeedproject.domain.follow.entity.Follow;
import F12.newsfeedproject.domain.follow.repository.FollowRepository;
import F12.newsfeedproject.domain.follow.service.FollowService;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.service.UserService;
import F12.newsfeedproject.global.exception.follow.DuplicatedFollowException;
import F12.newsfeedproject.global.exception.follow.FollowNotFoundException;
import F12.newsfeedproject.global.exception.user.UserNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiFollowService {

    private final UserService userService;
    private final FollowService followService;

    /**
     * 팔로우 하기
     * @param username
     * @param followerId
     */
    public void followUser(String username, Long followerId) {
        Optional<User> following = userService.findByUserName(username);
        if (following.isEmpty()) {
            throw new UserNotFoundException();
        }

        Optional<User> follower = userService.findByUserId(followerId);
        if (follower.isEmpty()) {
            throw new UserNotFoundException();
        }

        Optional<Follow> follow = followService.findByFollowingAndFollower(following.get(),
            follower.get());
        if (follow.isPresent()) {
            throw new DuplicatedFollowException();
        }
        followService.saveFollow(new Follow(following.get(), follower.get()));

    }

    /**
     * 언 팔로우 하기
     * @param username
     * @param followerId
     */
    public void unFollowUser(String username, Long followerId) {
        Optional<User> following = userService.findByUserName(username);
        if (following.isEmpty()) {
            throw new UserNotFoundException();
        }

        Optional<User> follower = userService.findByUserId(followerId);
        if (follower.isEmpty()) {
            throw new UserNotFoundException();
        }

        Optional<Follow> follow = followService.findByFollowingAndFollower(following.get(), follower.get());
        if (follow.isEmpty()) {
            throw new FollowNotFoundException();
        }
        followService.deleteFollow(follow.get());
    }

}

