package sc.sns.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sc.sns.domain.auth.entity.RefreshToken;
import sc.sns.domain.auth.presentation.dto.request.LogoutRequest;
import sc.sns.domain.auth.repository.AuthRepository;
import sc.sns.domain.auth.service.LogoutService;
import sc.sns.global.exception.CustomException;
import sc.sns.global.exception.ErrorCode;
import sc.sns.global.security.jwt.JwtProvider;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutService {
    private final JwtProvider jwtProvider;
    private final AuthRepository authRepository;

    @Transactional
    @Override
    public void logout(LogoutRequest request) {
        String token = request.getToken();

        if (!jwtProvider.validateToken(token)) {
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }

        Long userId = jwtProvider.getUserIdFromToken(token);
        authRepository.deleteByUserId(userId);
        jwtProvider.deleteRefreshToken(jwtProvider.getEmailFromToken(token));
    }
}

