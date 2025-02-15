package sc.sns.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenRefreshRequest {
    @NotBlank(message = "RefreshToken은 필수 입력값입니다.")
    private String refreshToken;
}
