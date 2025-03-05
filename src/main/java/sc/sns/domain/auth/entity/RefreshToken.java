package sc.sns.domain.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@RedisHash(value = "refresh_token")
public class RefreshToken {

    @Id
    private String token;

    @Indexed
    private UUID userId;

    @TimeToLive
    private Long expirationTime;
}
