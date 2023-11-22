package F12.newsfeedproject.domain.user.repository;

import F12.newsfeedproject.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUserName(String userName);

  Optional<User> findByUserEmail(String userEmail);
}
