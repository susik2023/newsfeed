package F12.newsfeedproject.api.board.dto.request;

import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.user.entity.User;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BoardRequestDto(
    @NotBlank
    @Size(max = 200)
    String boardTitle,

    @NotBlank
    @Size(max = 2000)
    @Lob
    String boardContent
) {

  public Board toEntity(User user) {
    return Board.builder()
        .boardTitle(boardTitle)
        .boardContent(boardContent)
        .user(user)
        .build();
  }
}
