package F12.newsfeedproject.domain.follow.service;

import F12.newsfeedproject.domain.follow.entity.Follow;
import F12.newsfeedproject.domain.follow.repository.FollowRepository;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.service.UserService;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    @Transactional
    public Follow saveFollow(Follow follow) {
        return followRepository.save(follow);
    }

    // 팔로우 내역 조회
    public Optional<Follow> findByFollowingAndFollower(User following, User follower) {
        return followRepository.findByFollowingAndFollower(following, follower);
    }

    @Transactional
    public void deleteFollow(Follow follow) {
        followRepository.delete(follow);
    }


}
