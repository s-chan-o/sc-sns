package sc.sns.domain.auth.repository;

import org.springframework.data.repository.CrudRepository;
import sc.sns.domain.auth.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByToken(String token);
}
