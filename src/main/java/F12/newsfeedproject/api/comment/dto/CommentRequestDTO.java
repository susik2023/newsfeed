package F12.newsfeedproject.api.comment.dto;

public record CommentRequestDTO(
    Long boardId,
    String commentContent
) {
}