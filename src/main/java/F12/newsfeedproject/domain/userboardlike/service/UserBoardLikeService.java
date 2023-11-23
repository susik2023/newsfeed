package F12.newsfeedproject.domain.userboardlike.service;

import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.userboardlike.entity.UserBoardLike;
import F12.newsfeedproject.domain.userboardlike.repository.UserBoardLikeRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBoardLikeService {

  private final UserBoardLikeRepository userBoardLikeRepository;

  @Transactional
  public UserBoardLike saveUserBoardLike(UserBoardLike userBoardLike) {
    return userBoardLikeRepository.save(userBoardLike);
  }

  @Transactional
  public void deleteById(Long id) {
    userBoardLikeRepository.deleteById(id);
  }

  public UserBoardLike findByUserBoardLikeId(Long userBoardLikeId) {
    return userBoardLikeRepository.findById(userBoardLikeId)
        .orElseThrow(IllegalArgumentException::new);
  }

  public Optional<UserBoardLike> findByUserAndBoard(User user, Board board) {
    return userBoardLikeRepository.findByUserAndBoard(user, board);
  }
}
