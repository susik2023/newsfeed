package F12.newsfeedproject.api.user.service;

import F12.newsfeedproject.api.user.dto.request.UserSignupRequestDTO;
import F12.newsfeedproject.api.user.dto.response.UserSignupResponseDTO;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.service.UserService;
import F12.newsfeedproject.global.exception.common.ErrorCode;
import F12.newsfeedproject.global.exception.member.AlreadyUserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiUserService {

  private final UserService userService;

  public UserSignupResponseDTO signupUser(UserSignupRequestDTO userSignupRequestDTO) {

    validateDuplicateUser(userSignupRequestDTO);
    User savedUser = userService.saveUser(userSignupRequestDTO.toEntity());

    return UserSignupResponseDTO.from(savedUser);
  }

  private void validateDuplicateUser(UserSignupRequestDTO userSignupRequestDTO) {

    userService.findByUserName(userSignupRequestDTO.userName()).ifPresent(user -> {
      throw new AlreadyUserExistException(ErrorCode.ALREADY_EXIST_USER_NAME_EXCEPTION);
    });

    userService.findByUserEmail(userSignupRequestDTO.userEmail()).ifPresent(user -> {
      throw new AlreadyUserExistException(ErrorCode.ALREADY_EXIST_EMAIL_EXCEPTION);
    });
  }

}
