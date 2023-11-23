package F12.newsfeedproject.global.security;

import F12.newsfeedproject.domain.user.entity.User;
import F12.newsfeedproject.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = userService.findByUserName(userName)
        .orElseThrow(() -> new UsernameNotFoundException("Not Found " + userName));

    return new UserDetailsImpl(user);
  }
}
