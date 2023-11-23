package F12.newsfeedproject.domain.userboardlike.repository;

import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.userboardlike.entity.UserBoardLike;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBoardLikeRepository extends JpaRepository<UserBoardLike, Long> {

  Optional<UserBoardLike> findByUserAndBoard(User user, Board board);

  void deleteByUserAndBoard(User user, Board board);

}
