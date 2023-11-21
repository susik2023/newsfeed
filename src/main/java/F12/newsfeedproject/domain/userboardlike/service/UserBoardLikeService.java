package F12.newsfeedproject.domain.userboardlike.service;

import F12.newsfeedproject.domain.userboardlike.entity.UserBoardLike;
import F12.newsfeedproject.domain.userboardlike.repository.UserBoardLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBoardLikeService {

    private final UserBoardLikeRepository userBoardLikeRepository;

    public UserBoardLike saveUserBoardLike(UserBoardLike userBoardLike) {
        return userBoardLikeRepository.save(userBoardLike);
    }

    public UserBoardLike findByUserBoardLikeId(Long userBoardLikeId) {
        return userBoardLikeRepository.findById(userBoardLikeId).orElseThrow(IllegalArgumentException::new);
    }
}
