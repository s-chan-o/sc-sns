package sc.sns.domain.auth.service;

import sc.sns.domain.auth.presentation.dto.request.SignupRequest;

public interface SignupService {
    void signup(SignupRequest request);
}
