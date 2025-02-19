package sc.sns.domain.auth.service;

import sc.sns.domain.auth.presentation.dto.request.ReissueTokenRequest;
import sc.sns.domain.auth.presentation.dto.response.ReissueTokenResponse;

public interface ReissueTokenService {
    ReissueTokenResponse execute(ReissueTokenRequest request);
}
