package F12.newsfeedproject.api.board.dto.response;

import F12.newsfeedproject.domain.board.entity.Board;
import java.time.LocalDateTime;

public record BoardResponseDto(
    Long boardId,
    String boardTitle,
    String boardContent,
    LocalDateTime createdDate,
    LocalDateTime modifiedDate
) {

  public static BoardResponseDto from(Board saveBoard) {
    return new BoardResponseDto(
        saveBoard.getBoardId(),
        saveBoard.getBoardTitle(),
        saveBoard.getBoardContent(),
        saveBoard.getCreatedDate(),
        saveBoard.getModifiedDate()
    );
  }
}
