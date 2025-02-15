package sc.sns.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sc.sns.domain.auth.presentation.dto.request.TokenRefreshRequest;
import sc.sns.domain.auth.presentation.dto.response.LoginResponse;
import sc.sns.domain.auth.repository.AuthRepository;
import sc.sns.domain.auth.service.TokenRefreshService;
import sc.sns.global.exception.CustomException;
import sc.sns.global.exception.ErrorCode;
import sc.sns.global.security.jwt.JwtProvider;

@Service
@RequiredArgsConstructor
public class TokenRefreshServiceImpl implements TokenRefreshService {
    private final JwtProvider jwtProvider;
    private final AuthRepository authRepository;

    @Transactional
    @Override
    public LoginResponse refreshAccessToken(TokenRefreshRequest request) {
        String refreshToken = request.getRefreshToken();

        if (!jwtProvider.validateToken(refreshToken)) {
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }

        Long userId = jwtProvider.getUserIdFromToken(refreshToken);
        String email = jwtProvider.getEmailFromToken(refreshToken);

        authRepository.findByUserId(userId)
                .filter(token -> token.getToken().equals(refreshToken))
                .orElseThrow(() -> new CustomException(ErrorCode.TOKEN_NOT_FOUND));

        String newAccessToken = jwtProvider.generateAccessToken(email);
        return LoginResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(refreshToken)
                .build();
    }
}


