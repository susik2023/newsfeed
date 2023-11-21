package F12.newsfeedproject.api.user.controller;

import F12.newsfeedproject.api.user.dto.UserSignupDTO;
import F12.newsfeedproject.api.user.service.ApiUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class ApiUserController {

    private final ApiUserService apiUserService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignupDTO.Response> signupUser(
            @Valid @RequestBody UserSignupDTO.Request userSignupRequestDTO) {

        UserSignupDTO.Response userSignupResponseDTO = apiUserService.signupUser(userSignupRequestDTO);

        return ResponseEntity.ok(userSignupResponseDTO);
    }
}
