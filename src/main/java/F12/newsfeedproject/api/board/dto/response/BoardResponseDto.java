package F12.newsfeedproject.api.board.dto.response;

import F12.newsfeedproject.domain.board.entity.Board;
import java.time.LocalDateTime;

public record BoardResponseDto(
    Long boardId,
    String boardTitle,
    String boardContent,
    String userName,
    LocalDateTime createdDate,
    LocalDateTime modifiedDate
) {

  public static BoardResponseDto from(Board board) {
    return new BoardResponseDto(
        board.getBoardId(),
        board.getBoardTitle(),
        board.getBoardContent(),
        board.getUser().getUserName(),
        board.getCreatedDate(),
        board.getModifiedDate()
    );
  }
}
