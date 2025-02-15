package sc.sns.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sc.sns.domain.auth.entity.RefreshToken;
import sc.sns.domain.auth.presentation.dto.request.LoginRequest;
import sc.sns.domain.auth.presentation.dto.response.LoginResponse;
import sc.sns.domain.auth.repository.AuthRepository;
import sc.sns.domain.auth.service.LoginService;
import sc.sns.domain.user.entity.User;
import sc.sns.domain.user.repository.UserRepository;
import sc.sns.global.exception.CustomException;
import sc.sns.global.exception.ErrorCode;
import sc.sns.global.security.jwt.JwtProvider;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Transactional
    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new CustomException(ErrorCode.INVALID_PASSWORD);
        }

        String accessToken = jwtProvider.generateAccessToken(user.getEmail());
        String refreshToken = jwtProvider.generateRefreshToken(user.getEmail());

        authRepository.findByUserId(user.getId()).ifPresent(authRepository::delete);
        RefreshToken tokenEntity = RefreshToken.builder()
                .userId(user.getId())
                .token(refreshToken)
                .expTime(LocalDateTime.now().plusDays(7))
                .build();
        authRepository.save(tokenEntity);

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}