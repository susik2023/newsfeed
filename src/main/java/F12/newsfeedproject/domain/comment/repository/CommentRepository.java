package F12.newsfeedproject.domain.comment.repository;

import F12.newsfeedproject.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
