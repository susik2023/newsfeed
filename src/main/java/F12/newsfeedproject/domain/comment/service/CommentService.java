package F12.newsfeedproject.domain.comment.service;

    import F12.newsfeedproject.domain.comment.entity.Comment;
    import F12.newsfeedproject.domain.comment.repository.CommentRepository;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment findByCommentId(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(IllegalArgumentException::new);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}