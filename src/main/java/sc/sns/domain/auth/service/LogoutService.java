package sc.sns.domain.auth.service;

import sc.sns.domain.auth.presentation.dto.request.LogoutRequest;
import sc.sns.domain.auth.presentation.dto.response.LogoutResponse;

public interface LogoutService {
    LogoutResponse execute(LogoutRequest request);
}
