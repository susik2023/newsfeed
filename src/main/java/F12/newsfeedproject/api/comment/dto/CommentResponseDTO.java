package F12.newsfeedproject.api.comment.dto;

import F12.newsfeedproject.domain.comment.entity.Comment;

public record CommentResponseDTO(
    Long commentId,
    String commentContent

){

  public CommentResponseDTO(Comment saveComment) {
    this(
        saveComment.getCommentId(),
        saveComment.getCommentContent()
    );
  }
}
