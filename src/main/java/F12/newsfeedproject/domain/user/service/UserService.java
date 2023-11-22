package F12.newsfeedproject.domain.user.service;

import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.repository.UserRepository;
import F12.newsfeedproject.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }
}
