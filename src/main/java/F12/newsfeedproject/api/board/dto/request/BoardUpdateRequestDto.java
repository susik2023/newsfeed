package F12.newsfeedproject.api.board.dto.request;

import F12.newsfeedproject.domain.board.entity.Board;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BoardUpdateRequestDto(
    @NotBlank
    @Size(max = 200)
    String boardTitle,

    @NotBlank
    @Size(max = 2000)
    @Lob
    String boardContent
) {

  public Board toEntity() {
    return Board.builder()
        .boardTitle(boardTitle)
        .boardContent(boardContent)
        .build();
  }
}
