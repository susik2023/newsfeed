package F12.newsfeedproject.domain.follow.service;

import F12.newsfeedproject.domain.follow.entity.Follow;
import F12.newsfeedproject.domain.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    public Follow saveFollow(Follow follow) {
        return followRepository.save(follow);
    }

    public Follow findByFollowId(Long followId) {
        return followRepository.findById(followId).orElseThrow(IllegalArgumentException::new);
    }

    public void deleteFollow(Long followId) {
        followRepository.deleteById(followId);
    }
}
