package F12.newsfeedproject.api.follow.service;

import F12.newsfeedproject.domain.follow.entity.Follow;
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

  public void followUser(String username, Long followerId) {
    User user = checkUser(username);
    User follower = checkFollwer(followerId);

    if (isAlreadyFollow(user, follower)) {
      throw new DuplicatedFollowException();
    }

    followService.saveFollow(new Follow(user, follower));
  }

  public void unFollowUser(String username, Long followerId) {
    User user = checkUser(username);
    User follower = checkFollwer(followerId);

    if (!isAlreadyFollow(user, follower)) {
      throw new FollowNotFoundException();
    }
    Optional<Follow> follow = followService.findByFollowingAndFollower(user, follower);

    followService.deleteFollow(follow.get());
  }

  private User checkUser(String username) {
    Optional<User> user = userService.findByUserName(username);
    if (user.isEmpty()) {
      throw new UserNotFoundException();
    }
    return user.get();
  }

  private User checkFollwer(Long followerId) {
    Optional<User> follower = userService.findByUserId(followerId);
    if (follower.isEmpty()) {
      throw new UserNotFoundException();
    }
    return follower.get();
  }

  private boolean isAlreadyFollow(User following, User follower) {
    Optional<Follow> optionalFollow = followService.findByFollowingAndFollower(following,
        follower);
    return optionalFollow.isPresent();
  }

}

