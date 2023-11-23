package F12.newsfeedproject.api.board.dto.request;

import F12.newsfeedproject.domain.board.entity.Board;
import jakarta.validation.constraints.NotBlank;

public record BoardUpdateRequestDto(
    @NotBlank String boardTitle,
    @NotBlank String boardContent
) {

  public Board toEntity() {
    return Board.builder()
        .boardTitle(boardTitle)
        .boardContent(boardContent)
        .build();
  }
}
