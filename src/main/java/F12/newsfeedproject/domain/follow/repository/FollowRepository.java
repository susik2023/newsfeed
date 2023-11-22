package F12.newsfeedproject.domain.follow.repository;

import F12.newsfeedproject.domain.follow.entity.Follow;
import F12.newsfeedproject.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    Optional<Follow> findByFollowerAndFollowing(User follower, User following);
    void deleteFollowByFollowerAndFollowing(User follower, User following);
}
