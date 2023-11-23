package F12.newsfeedproject.api.board.service;

import F12.newsfeedproject.api.board.dto.request.BoardRequestDto;
import F12.newsfeedproject.api.board.dto.response.BoardResponseDto;
import F12.newsfeedproject.api.board.dto.request.BoardUpdateRequestDto;
import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.board.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApiBoardService {

  private final BoardService boardService;

  // 게시글 작성
  @Transactional
  public BoardResponseDto saveBoard(BoardRequestDto requestDto) {
    Board savedBoard = boardService.saveBoard(requestDto.toEntity());
    return BoardResponseDto.from(savedBoard);
  }

  // 게시글 단건 조회
  public BoardResponseDto getBoard(Long boardId) {
    Board getBoard = boardService.findByBoardId(boardId);
    return BoardResponseDto.from(getBoard);
  }

  // 게시글 전체 목록 조회
  public List<BoardResponseDto> getBoards() {
    List<Board> boardList = boardService.getBoards();
    return boardList.stream().map(BoardResponseDto::from).toList();
  }

  // 게시글 수정
  @Transactional
  public BoardResponseDto updateBoard(Long boardId, BoardUpdateRequestDto requestDto) {
    Board updateBoard = boardService.findByBoardId(boardId);
    boardService.updateBoard(updateBoard, requestDto.toEntity());
    return BoardResponseDto.from(updateBoard);
  }

  // 게시글 삭제
  public void deleteBoard(Long boardId) {
    boardService.deleteBoard(boardId);
  }
}
