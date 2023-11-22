package F12.newsfeedproject.api.board.controller;

import F12.newsfeedproject.api.board.dto.BoardRequestDto;
import F12.newsfeedproject.api.board.dto.BoardResponseDto;
import F12.newsfeedproject.api.board.dto.BoardUpdateRequestDto;
import F12.newsfeedproject.api.board.service.ApiBoardService;
import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.board.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class ApiBoardController {

  private final ApiBoardService boardService;

  // 게시글 작성
  @PostMapping
  public ResponseEntity<BoardResponseDto> saveBoard(@RequestBody BoardRequestDto requestDto) {
    BoardResponseDto responseDto = boardService.saveBoard(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
  }

  // 게시글 단건 조회
  @GetMapping("/{boardId}")
  public ResponseEntity<BoardResponseDto> getBoard(@PathVariable Long boardId) {
    BoardResponseDto responseDto = boardService.getBoard(boardId);
    return ResponseEntity.ok(responseDto);
  }

  // 게시글 전체 목록 조회
  @GetMapping
  public ResponseEntity<List<BoardResponseDto>> getBoards() {
    List<BoardResponseDto> responseDto = boardService.getBoards();
    return ResponseEntity.ok(responseDto);
  }

  // 게시글 수정
  @PatchMapping("/{boardId}")
  public ResponseEntity<BoardResponseDto> updateBoard(
      @PathVariable Long boardId, @RequestBody BoardUpdateRequestDto requestDto) {
    BoardResponseDto responseDto = boardService.updateBoard(boardId, requestDto);
    return ResponseEntity.ok(responseDto);
  }

  // 게시글 삭제
  @DeleteMapping("/{boardId}")
  public ResponseEntity<Void> deleteBoard(@PathVariable Long boardId) {
    boardService.deleteBoard(boardId);
    return ResponseEntity.noContent().build();
  }
}

