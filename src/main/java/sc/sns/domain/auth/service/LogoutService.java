package sc.sns.domain.auth.service;

import sc.sns.domain.auth.presentation.dto.request.LogoutRequest;

public interface LogoutService {
    void logout(LogoutRequest request);
}
