package F12.newsfeedproject.domain.follow.service;

import F12.newsfeedproject.domain.follow.entity.Follow;
import F12.newsfeedproject.domain.follow.repository.FollowRepository;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final UserService userService;

    public Follow saveFollow(Follow follow) {
        return followRepository.save(follow);
    }

    public Follow findByFollowerId(Long followerId) {
        return followRepository.findById(followerId).orElseThrow(IllegalArgumentException::new);
    }

    public void deleteFollow(Long followId) {
        followRepository.deleteById(followId);
    }

    public void followOrUnFollowUser(Long userId, Long followerId) {
        User following = userService.findByUserId(userId);
        User follower = userService.findByUserId(followerId);

        Optional<Follow> follow = followRepository.findByFollowerAndFollowing(following,
            follower);

        if (follow.isPresent()) {
            followRepository.deleteFollowByFollowerAndFollowing(following, follower);
        } else {
            followRepository.save(new Follow(following, follower));
        }
    }

}
