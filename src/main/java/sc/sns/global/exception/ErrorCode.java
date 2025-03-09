package sc.sns.global.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    // Authentication
    EMAIL_ALREADY_EXISTS(409, "이미 사용 중인 이메일입니다."),
    INVALID_CREDENTIALS(401, "잘못된 이메일 또는 비밀번호입니다."),
    INVALID_REFRESH_TOKEN(403, "유효하지 않은 리프레시 토큰입니다."),
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),
    UNAUTHORIZED(401, "권한이 없습니다."),
    ACCESS_DENIED(403, "접근 권한이 없습니다."),
    PASSWORD_MISMATCH(400, "비밀번호가 일치하지 않습니다."),
    ADMIN_PENDING(403, "관리자 승인 대기 중입니다."),

    // Request
    BAD_REQUEST(400, "잘못된 요청입니다."),
    INVALID_INPUT(400, "입력값이 올바르지 않습니다."),
    METHOD_NOT_ALLOWED(405, "허용되지 않은 HTTP 메서드입니다."),
    UNSUPPORTED_MEDIA_TYPE(415, "지원하지 않는 미디어 타입입니다."),

    // Server
    INTERNAL_SERVER_ERROR(500, "서버 내부 오류가 발생했습니다."),
    SERVICE_UNAVAILABLE(503, "서비스를 사용할 수 없습니다."),

    // Data
    DATA_NOT_FOUND(404, "데이터를 찾을 수 없습니다."),
    DUPLICATE_RESOURCE(409, "중복된 리소스가 존재합니다."),
    DATABASE_ERROR(500, "데이터베이스 오류가 발생했습니다."),

    // Token
    EXPIRED_ACCESS_TOKEN(401, "액세스 토큰이 만료되었습니다."),
    EXPIRED_REFRESH_TOKEN(401, "리프레시 토큰이 만료되었습니다."),
    INVALID_ACCESS_TOKEN(401, "유효하지 않은 액세스 토큰입니다."),

    // External API
    EXTERNAL_API_ERROR(502, "외부 API 호출 중 오류가 발생했습니다."),
    EMAIL_SEND_FAILED(500, "이메일 전송에 실패했습니다."),

    // File Upload
    FILE_UPLOAD_FAILED(500, "파일 업로드 중 오류가 발생했습니다."),
    FILE_NOT_FOUND(404, "파일을 찾을 수 없습니다."),
    FILE_TOO_LARGE(413, "파일 크기가 너무 큽니다."),
    FILE_EXTENSION_INVALID(400, "파일 확장자가 유효하지 않습니다."),

    // WebSocket
    WEBSOCKET_CONNECTION_FAILED(500, "웹소켓 연결에 실패했습니다."),
    MESSAGE_SEND_FAILED(500, "메시지 전송에 실패했습니다.");

    private final int status;
    private final String message;
}
