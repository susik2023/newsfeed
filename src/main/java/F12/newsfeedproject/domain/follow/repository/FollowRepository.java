package F12.newsfeedproject.domain.follow.repository;

import F12.newsfeedproject.domain.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
