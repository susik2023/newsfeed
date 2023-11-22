package F12.newsfeedproject.global.jwt;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserLoginDto {

  @Size(min = 2, max = 20)
  @NotBlank(message = "이름은 필수 입력 값입니다.")
  private String userName;

  @Size(min = 8, max = 15)
  @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
  private String userPassword;

}
