package F12.newsfeedproject.api.board.service;

import F12.newsfeedproject.api.board.dto.BoardRequestDto;
import F12.newsfeedproject.api.board.dto.BoardResponseDto;
import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiBoardService {

    private final BoardService boardService;

    // 게시글 작성
    public BoardResponseDto saveBoard(BoardRequestDto requestDto) {


        Board savedBoard = boardService.saveBoard(requestDto.toEntity());

        return new BoardResponseDto(savedBoard);
    }

}
