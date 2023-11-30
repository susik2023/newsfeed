package F12.newsfeedproject.api.comment.dto;

import jakarta.validation.constraints.NotBlank;

public record CommentRequestDTO(
    @NotBlank
    Long boardId,
    @NotBlank
    String commentContent
) {
}