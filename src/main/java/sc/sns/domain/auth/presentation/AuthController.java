package sc.sns.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.sns.domain.auth.presentation.dto.request.LoginRequest;
import sc.sns.domain.auth.presentation.dto.request.LogoutRequest;
import sc.sns.domain.auth.presentation.dto.request.SignupRequest;
import sc.sns.domain.auth.presentation.dto.request.TokenRefreshRequest;
import sc.sns.domain.auth.presentation.dto.response.LoginResponse;
import sc.sns.domain.auth.service.LoginService;
import sc.sns.domain.auth.service.LogoutService;
import sc.sns.domain.auth.service.SignupService;
import sc.sns.domain.auth.service.TokenRefreshService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SignupService signupService;
    private final LoginService loginService;
    private final LogoutService logoutService;
    private final TokenRefreshService tokenRefreshService;


    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody SignupRequest request) {
        signupService.signup(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginService.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequest request) {
        logoutService.logout(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshAccessToken(@RequestBody TokenRefreshRequest request) {
        return ResponseEntity.ok(tokenRefreshService.refreshAccessToken(request));
    }
}
