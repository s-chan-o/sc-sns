package sc.sns.domain.auth.service;

import sc.sns.domain.auth.presentation.dto.request.TokenRefreshRequest;
import sc.sns.domain.auth.presentation.dto.response.LoginResponse;

public interface TokenRefreshService {
    LoginResponse refreshAccessToken(TokenRefreshRequest request);
}
