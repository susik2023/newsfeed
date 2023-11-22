package F12.newsfeedproject.api.board.controller;

import F12.newsfeedproject.api.board.dto.BoardRequestDto;
import F12.newsfeedproject.api.board.dto.BoardResponseDto;
import F12.newsfeedproject.api.board.service.ApiBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
