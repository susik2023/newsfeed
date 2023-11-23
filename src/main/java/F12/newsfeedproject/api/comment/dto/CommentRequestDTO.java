package F12.newsfeedproject.api.comment.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {

  private Long boardId;
  private String commentContent;
}