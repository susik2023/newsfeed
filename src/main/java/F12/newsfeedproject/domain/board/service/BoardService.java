package F12.newsfeedproject.domain.board.service;

import F12.newsfeedproject.api.board.dto.BoardUpdateRequestDto;
import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.board.repository.BoardRepository;
import F12.newsfeedproject.global.exception.board.BoardNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

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
  public Board updateBoard(Long boardId, BoardUpdateRequestDto requestDto) {
    Board board = boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new);
    board.update(requestDto);
    return board;
  }

  public void deleteBoard(Long boardId) {
    Board board = boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new);
    boardRepository.deleteById(boardId);
  }
}