package F12.newsfeedproject.api.user.dto.request;

import F12.newsfeedproject.domain.user.constant.UserRole;
import F12.newsfeedproject.domain.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.password.PasswordEncoder;

public record UserSignupRequestDTO(
    @Size(min = 2, max = 20)
    @NotBlank(message = "이름은 필수 입력 값입니다.") String userName,
    @Size(min = 8, max = 15)
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.") String userPassword,
    @NotBlank @Email String userEmail,
    @NotBlank(message = "프로필 사진 URL은 필수 입력 값입니다.") String userImageUrl,
    @NotBlank(message = "자기소개는 필수 입력 값입니다.") String userIntroduce
) {

  public User toEntity(PasswordEncoder passwordEncoder) {
    return User.builder()
        .userName(userName)
        .userPassword(passwordEncoder.encode(userPassword))
        .userEmail(userEmail)
        .userImageUrl(userImageUrl)
        .userIntroduce(userIntroduce)
        .userRole(UserRole.USER)
        .build();
  }
}
