package F12.newsfeedproject.api.user.dto.response;

import F12.newsfeedproject.domain.user.entity.User;

public record UserSignupResponseDTO(
    Long userId,
    String userName,
    String userEmail,
    String userImageUrl,
    String userIntroduce
) {

  public static UserSignupResponseDTO from(User user) {
    return new UserSignupResponseDTO(user.getUserId(), user.getUserName(), user.getUserEmail(),
        user.getUserImageUrl(),
        user.getUserIntroduce());
  }
}
