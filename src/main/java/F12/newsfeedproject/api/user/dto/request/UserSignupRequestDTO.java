package F12.newsfeedproject.api.user.dto.request;

import F12.newsfeedproject.domain.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserSignupRequestDTO(
    @NotBlank String userName,
    @NotBlank String userPassword,
    @NotBlank @Email String userEmail,
    @NotBlank String userImageUrl,
    @NotBlank String userIntroduce
) {

  public User toEntity() {
    return User.builder()
        .userName(userName)
        .userPassword(userPassword)
        .userEmail(userEmail)
        .userImageUrl(userImageUrl)
        .userIntroduce(userIntroduce)
        .build();
  }
}
