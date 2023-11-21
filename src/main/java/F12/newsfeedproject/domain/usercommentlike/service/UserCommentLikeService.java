package F12.newsfeedproject.domain.usercommentlike.service;

import F12.newsfeedproject.domain.usercommentlike.entity.UserCommentLike;
import F12.newsfeedproject.domain.usercommentlike.repository.UserCommentLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommentLikeService {

    private final UserCommentLikeRepository userCommentLikeRepository;

    public UserCommentLike saveUserCommentLike(UserCommentLike userCommentLike) {
        return userCommentLikeRepository.save(userCommentLike);
    }

    public UserCommentLike findByUserCommentLikeId(Long userCommentLikeId) {
        return userCommentLikeRepository.findById(userCommentLikeId).orElseThrow(IllegalArgumentException::new);
    }
}
