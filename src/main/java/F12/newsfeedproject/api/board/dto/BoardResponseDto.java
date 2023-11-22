package F12.newsfeedproject.api.board.dto;

import F12.newsfeedproject.domain.board.entity.Board;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BoardResponseDto {
  private Long boardId;
  private String boardTitle;
  private String boardContent;
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;

  public BoardResponseDto(Board saveBoard) {
    this.boardId = saveBoard.getBoardId();
    this.boardTitle = saveBoard.getBoardTitle();
    this.boardContent = saveBoard.getBoardContent();
    this.createdDate = saveBoard.getCreatedDate();
    this.modifiedDate = saveBoard.getModifiedDate();
  }
}
