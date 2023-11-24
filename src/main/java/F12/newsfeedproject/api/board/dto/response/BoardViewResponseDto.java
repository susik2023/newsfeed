package F12.newsfeedproject.api.board.dto.response;

import F12.newsfeedproject.domain.board.entity.Board;
import java.time.LocalDateTime;
import lombok.Builder;


@Builder
public record BoardViewResponseDto(

    String userName,
    Long boardId,
    String boardTitle,
    String boardContent,
    LocalDateTime createdDate,
    LocalDateTime modifiedDate
) {

  public static BoardViewResponseDto from(Board board) {
    return BoardViewResponseDto.builder()
        .userName(board.getUser().getUserName())
        .boardId(board.getBoardId())
        .boardTitle(board.getBoardTitle())
        .boardContent(board.getBoardContent())
        .createdDate(board.getCreatedDate())
        .modifiedDate(board.getModifiedDate())
        .build();
  }
}
