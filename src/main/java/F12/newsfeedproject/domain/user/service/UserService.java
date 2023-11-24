package F12.newsfeedproject.domain.user.service;

import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.repository.UserRepository;
import F12.newsfeedproject.global.exception.user.UserNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public Optional<User> findByUserName(String userName) {
    return userRepository.findByUserName(userName);
  }

  public Optional<User> findByUserEmail(String userEmail) {
    return userRepository.findByUserEmail(userEmail);
  }

  public Optional<User> findByUserId(Long userId) {
    return userRepository.findById(userId);
  }

  @Transactional
  public void updateRefreshToken(String refreshToken, Long userId) {
    User findUser = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    findUser.updateRefreshToken(refreshToken);
  }

  public void updateUser(User findUser, User modifyUser) {
    findUser.updateUser(modifyUser);
  }

  @Transactional
  public void logoutUser(Long userId) {
    User findUser = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    findUser.logout();
  }
}
