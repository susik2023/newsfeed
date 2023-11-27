package F12.newsfeedproject.domain.board.service;

import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.board.repository.BoardRepository;
import F12.newsfeedproject.global.exception.board.BoardNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  @Transactional
  public Board saveBoard(Board board) {
    return boardRepository.save(board);
  }

  public Board findByBoardId(Long boardId) {
    return boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new);
  }

  public List<Board> getBoards() {
    return boardRepository.findAllByOrderByCreatedDateDesc();
  }

  @Transactional
  public void updateBoard(Board updateBoard, Board board) {
    updateBoard.update(board);
  }

  public void deleteBoard(Long boardId) {
    boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new);
    boardRepository.deleteById(boardId);
  }

  public Long getAuthorIdByBoardId(Long boardId) {
    Board board = boardRepository.findByBoardIdWithUser(boardId).orElseThrow(BoardNotFoundException::new);
    return board.getUser().getUserId();
  }

  public List<Board> findAllUserFollowerBoard(Long userId, Pageable pageable) {
    return boardRepository.findAllUserFollowerBoard(userId, pageable).getContent();
  }
  public List<Board> findAllLikeBoards(Long userId, Pageable pageable) {
    return boardRepository.findAllLikeBoards(userId, pageable);
  }

  public Board findByBoardIdWithUser(Long boardId) {
    return boardRepository.findByBoardIdWithUser(boardId).orElseThrow(BoardNotFoundException::new);
  }
}

