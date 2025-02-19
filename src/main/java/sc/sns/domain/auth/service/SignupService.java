package sc.sns.domain.auth.service;

import sc.sns.domain.auth.presentation.dto.request.SignupRequest;
import sc.sns.domain.auth.presentation.dto.response.SignupResponse;

public interface SignupService {
    SignupResponse execute(SignupRequest request);
}
