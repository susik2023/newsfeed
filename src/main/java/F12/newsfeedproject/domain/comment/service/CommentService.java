package F12.newsfeedproject.domain.comment.service;

import F12.newsfeedproject.api.comment.dto.CommentRequestDTO;
import F12.newsfeedproject.api.comment.dto.CommentResponseDTO;
import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.board.service.BoardService;
import F12.newsfeedproject.domain.comment.entity.Comment;
import F12.newsfeedproject.domain.comment.repository.CommentRepository;
import F12.newsfeedproject.domain.user.entity.User;
import jakarta.transaction.Transactional;
import java.util.concurrent.RejectedExecutionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardService boardService;
    public CommentResponseDTO createComment(CommentRequestDTO dto, User user) {
        Board board  = boardService.findByBoardId(dto.getBoardId());

        Comment comment = new Comment(dto);
        comment.setUser(user);
//        comment.setBoard(board);
        Comment saveComment = commentRepository.save(comment);


        return new CommentResponseDTO(saveComment);
    }

    @Transactional
    public CommentResponseDTO updateComment(Long commentId, CommentRequestDTO commentRequestDTO, User user) {
        Comment comment = getUserComment(commentId, user);

        comment.setCommentContent(commentRequestDTO.getCommentContent());

        return new CommentResponseDTO(comment);
    }

    public void deleteComment(Long commentId, User user) {
        Comment comment = getUserComment(commentId, user);

        commentRepository.delete(comment);
    }

    private Comment getUserComment(Long commentId, User user) {
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() -> new IllegalArgumentException());

        if(!user.getUserId().equals(comment.getUser().getUserId())) {
            throw new RejectedExecutionException();
        }
        return comment;
    }

}
