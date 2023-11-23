package F12.newsfeedproject.api.board.dto.request;

import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.service.UserService;
import jakarta.validation.constraints.NotBlank;

public record BoardRequestDto(
    @NotBlank String boardTitle,
    @NotBlank String boardContent
) {

  public Board toEntity(Long userId) {
    User user = User.builder().userId(userId).build();
    return Board.builder()
        .boardTitle(boardTitle)
        .boardContent(boardContent)
        .user(user)
        .build();
  }
}
