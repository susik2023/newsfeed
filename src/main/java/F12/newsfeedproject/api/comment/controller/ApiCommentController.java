package F12.newsfeedproject.api.comment.controller;

import F12.newsfeedproject.api.comment.dto.CommentRequestDTO;
import F12.newsfeedproject.api.comment.dto.CommentResponseDTO;
import F12.newsfeedproject.api.comment.service.ApiCommentService;
import F12.newsfeedproject.global.security.UserDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/comments")
@RestController
@RequiredArgsConstructor
public class ApiCommentController {

  private final ApiCommentService apiCommentService;

  @PostMapping
  public ResponseEntity<CommentResponseDTO> postComment(
      @Valid @RequestBody CommentRequestDTO commentRequestDTO,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    CommentResponseDTO responseDTO = apiCommentService.createComment(commentRequestDTO,
        userDetails.getUser());

    return ResponseEntity.status(201).body(responseDTO);
  }

  @PatchMapping("/{commentId}")
  public ResponseEntity<CommentResponseDTO> updateComment(@PathVariable Long commentId,
      @Valid @RequestBody CommentRequestDTO commentRequestDTO,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {

    CommentResponseDTO responseDTO = apiCommentService.updateComment(commentId, commentRequestDTO,
        userDetails.getUser());
    return ResponseEntity.ok().body(responseDTO);

  }


  @DeleteMapping("/{commentId}")
  public ResponseEntity<CommentResponseDTO> deleteComment(@PathVariable Long commentId,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {

    apiCommentService.deleteComment(commentId, userDetails.getUser());
    return ResponseEntity.noContent().build();

  }

}