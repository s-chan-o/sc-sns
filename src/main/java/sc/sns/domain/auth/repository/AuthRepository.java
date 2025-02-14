package sc.sns.domain.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.sns.domain.auth.entity.RefreshToken;

public interface AuthRepository extends JpaRepository<RefreshToken, String> {
}
