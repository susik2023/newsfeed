package F12.newsfeedproject.domain.usercommentlike.repository;

import F12.newsfeedproject.domain.usercommentlike.entity.UserCommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentLikeRepository extends JpaRepository<UserCommentLike, Long> {
}
