package F12.newsfeedproject.api.user.dto;

import F12.newsfeedproject.domain.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserSignupDTO {

    public static record Request(
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
                    .introduce(userIntroduce)
                    .build();
        }
    }

    public static record Response(
            Long userId,
            String userName,
            String userEmail,
            String userImageUrl,
            String userIntroduce
    ) {
        public static UserSignupDTO.Response from(User user) {
            return new UserSignupDTO.Response(user.getUserId(), user.getUserName(), user.getUserEmail(),
                    user.getUserImageUrl(),
                    user.getIntroduce());
        }
    }
}
