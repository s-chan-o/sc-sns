package sc.sns.domain.auth.service;

import sc.sns.domain.auth.presentation.dto.request.LoginRequest;
import sc.sns.domain.auth.presentation.dto.response.LoginResponse;

public interface LoginService {
    LoginResponse execute(LoginRequest request);
}
