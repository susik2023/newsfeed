package F12.newsfeedproject.domain.user.repository;

import F12.newsfeedproject.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);

    Optional<User> findByUserName(String userName);
}
