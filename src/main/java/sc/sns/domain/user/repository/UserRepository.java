package sc.sns.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.sns.domain.user.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}