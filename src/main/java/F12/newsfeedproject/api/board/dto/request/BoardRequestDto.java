package F12.newsfeedproject.api.board.dto.request;

import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.user.entity.User;
import jakarta.validation.constraints.NotBlank;

public record BoardRequestDto(
    @NotBlank String boardTitle,
    @NotBlank String boardContent
) {

  public Board toEntity(User user) {
    return Board.builder()
        .boardTitle(boardTitle)
        .boardContent(boardContent)
        .user(user)
        .build();
  }
}
