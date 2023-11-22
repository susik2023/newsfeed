package F12.newsfeedproject.api.user.service;

import F12.newsfeedproject.api.user.dto.UserSignupDTO;
import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiUserService {

    private final UserService userService;

    public UserSignupDTO.Response signupUser(UserSignupDTO.Request userSignupRequestDTO) {
        User savedUser = userService.saveUser(userSignupRequestDTO.toEntity());

        return UserSignupDTO.Response.from(savedUser);
    }
}
