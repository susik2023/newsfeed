package F12.newsfeedproject.api.comment.dto;

import F12.newsfeedproject.domain.comment.entity.Comment;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CommentResponseDTO {
  private Long commentId;
  private String commentContent;
  private LocalDateTime createDate;

  public CommentResponseDTO(Comment comment) {
    this.commentId = comment.getCommentId();
    this.commentContent = comment.getCommentContent();
    this.createDate = comment.getCreateDate();
  }
}