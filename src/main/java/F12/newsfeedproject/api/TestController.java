package F12.newsfeedproject.api;

import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.global.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/test")
  public void test(@AuthenticationPrincipal UserDetailsImpl userDetails) {
    User user = userDetails.getUser();
  }

}
