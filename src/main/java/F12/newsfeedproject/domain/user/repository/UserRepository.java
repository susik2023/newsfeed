package F12.newsfeedproject.domain.user.repository;

import F12.newsfeedproject.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
