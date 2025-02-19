package sc.sns.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReissueTokenRequest {

    @NotBlank(message = "리프레시 토큰은 필수 입력값입니다.")
    private String refreshToken;
}
