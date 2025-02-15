package sc.sns.domain.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sc.sns.domain.auth.entity.RefreshToken;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByUserId(Long userId);
    void deleteByUserId(Long userId);
}
