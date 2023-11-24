package F12.newsfeedproject.api.like.service;

import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.board.service.BoardService;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.service.UserService;
import F12.newsfeedproject.domain.userboardlike.entity.UserBoardLike;
import F12.newsfeedproject.domain.userboardlike.service.UserBoardLikeService;
import F12.newsfeedproject.global.exception.follow.DuplicatedFollowException;
import F12.newsfeedproject.global.exception.like.DuplicatedLikeException;
import F12.newsfeedproject.global.exception.like.NotFoundLikeException;
import F12.newsfeedproject.global.exception.user.NoAuthorizationException;
import F12.newsfeedproject.global.exception.user.UserNotFoundException;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiLikeService {

  private final BoardService boardService;
  private final UserBoardLikeService userBoardLikeService;

  @Transactional
  public void createLikeBoard(User user, Long boardId) {
    Board board = boardService.findByBoardId(boardId);

    userBoardLikeService.findByUserAndBoard(user, board)
        .ifPresent(existingLike -> {
          throw new DuplicatedLikeException();
        });

    UserBoardLike userBoardLike = UserBoardLike.fromUserAndBoard(user, board);

    userBoardLikeService.saveUserBoardLike(userBoardLike);
  }

  @Transactional
  public void deleteLikeBoard(User user, Long boardId) {
    Board board = boardService.findByBoardId(boardId);

    UserBoardLike optionalUserBoardLike = userBoardLikeService.findByUserAndBoard(user, board)
        .orElseThrow(NotFoundLikeException::new);

    userBoardLikeService.deleteById(optionalUserBoardLike.getUserBoardLikeId());
  }
}
