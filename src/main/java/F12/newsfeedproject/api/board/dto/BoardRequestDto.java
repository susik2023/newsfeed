package F12.newsfeedproject.api.board.dto;

import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardRequestDto {
  private String boardTitle;
  private String boardContent;

  public Board toEntity() {
    return Board.builder()
        .boardTitle(boardTitle)
        .boardContent(boardContent)
        .build();
  }
}
