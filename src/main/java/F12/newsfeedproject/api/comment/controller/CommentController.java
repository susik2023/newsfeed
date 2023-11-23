package F12.newsfeedproject.api.comment.controller;

import F12.newsfeedproject.api.comment.dto.CommentRequestDTO;
import F12.newsfeedproject.api.comment.dto.CommentResponseDTO;
import F12.newsfeedproject.domain.comment.service.CommentService;
import F12.newsfeedproject.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/comments")
@RestController
@RequiredArgsConstructor
public class CommentController {

  private final CommentService commentService;

  @PostMapping
  public ResponseEntity<CommentResponseDTO> postComment(@RequestBody CommentRequestDTO commentRequestDTO, @AuthenticationPrincipal UserDetailsImpl userDetails) {
    CommentResponseDTO responseDTO = commentService.createComment(commentRequestDTO, userDetails.getUser());

    return ResponseEntity.status(201).body(responseDTO);
  }

  @PutMapping("/{commentId}")
  public ResponseEntity<CommentResponseDTO> putComment(@PathVariable Long commentId, @RequestBody CommentRequestDTO commentRequestDTO, @AuthenticationPrincipal UserDetailsImpl userDetails) {

      CommentResponseDTO responseDTO = commentService.updateComment(commentId, commentRequestDTO, userDetails.getUser());
      return ResponseEntity.ok().body(responseDTO);

  }


  @DeleteMapping("/{commentId}")
  public ResponseEntity<CommentResponseDTO> deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails) {

      commentService.deleteComment(commentId, userDetails.getUser());
      return ResponseEntity.noContent().build();

  }
}