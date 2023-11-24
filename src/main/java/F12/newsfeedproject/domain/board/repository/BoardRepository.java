package F12.newsfeedproject.domain.board.repository;

import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.user.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

  List<Board> findAllByOrderByCreatedDateDesc();

  @Query(
      "select b from Board b join fetch b.user u where u in " +
          "(select f.follower from Follow f where f.following.userId = :userId)"
  )
  List<Board> findAllUserFollowerBoard(@Param("userId") Long userId);

//  @Query(
//      "select b from Board b join fetch b.boardId id where id in " +
//          "(select ubl.board from UserBoardLike ubl where ubl.user = :userId)"
//  )
  @Query(
      "select b from Board b join fetch b.user where b in " +
          "(select ubl.board from UserBoardLike ubl where ubl.user.userId = :userId)"  )
  List<Board> findAllLikeBoards(@Param("userId") Long userId);


}
