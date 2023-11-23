package F12.newsfeedproject.api.user.service;

import F12.newsfeedproject.api.user.dto.request.UserModifyRequestDTO;
import F12.newsfeedproject.api.user.dto.request.UserSignupRequestDTO;
import F12.newsfeedproject.api.user.dto.response.UserResponseDTO;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.service.UserService;
import F12.newsfeedproject.global.exception.common.ErrorCode;
import F12.newsfeedproject.global.exception.member.AlreadyUserExistException;
import F12.newsfeedproject.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApiUserService {

  private final UserService userService;

  private final PasswordEncoder passwordEncoder;

  public UserResponseDTO signupUser(UserSignupRequestDTO userSignupRequestDTO) {

    validateDuplicateUser(userSignupRequestDTO);
    User savedUser = userService.saveUser(userSignupRequestDTO.toEntity(passwordEncoder));

    return UserResponseDTO.from(savedUser);
  }

  private void validateDuplicateUser(UserSignupRequestDTO userSignupRequestDTO) {

    userService.findByUserName(userSignupRequestDTO.userName()).ifPresent(user -> {
      throw new AlreadyUserExistException(ErrorCode.ALREADY_EXIST_USER_NAME_EXCEPTION);
    });

    userService.findByUserEmail(userSignupRequestDTO.userEmail()).ifPresent(user -> {
      throw new AlreadyUserExistException(ErrorCode.ALREADY_EXIST_EMAIL_EXCEPTION);
    });
  }

  @Transactional
  public UserResponseDTO updateUser(UserModifyRequestDTO userModifyRequestDTO, Long userId) {
    User findUser = userService.findByUserId(userId).orElseThrow(UserNotFoundException::new);
    userService.updateUser(findUser, userModifyRequestDTO.toEntity());

    return UserResponseDTO.from(findUser);
  }
}
