package sc.sns.global.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    /* Auth */
    EMAIL_ALREADY_EXISTS(409, "이미 존재하는 이메일입니다."),
    NICKNAME_ALREADY_EXISTS(409, "이미 존재하는 닉네임입니다."),
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),
    INVALID_PASSWORD(401, "비밀번호가 일치하지 않습니다."),
    EXPIRED_TOKEN(401, "토큰이 만료되었습니다."),
    INVALID_TOKEN_TYPE(401, "유효하지 않은 토큰 타입입니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다."),
    EXPIRED_REFRESH_TOKEN(401, "만료된 리프레시 토큰입니다."),
    INVALID_REFRESH_TOKEN(401, "유효하지 않거나 만료된 리프레시 토큰입니다."),
    UNAUTHORIZED(401, "권한이 없습니다."),

    /* Post */
    POST_NOT_FOUND(404, "게시글을 찾을 수 없습니다."),
    UNAUTHORIZED_POST_ACCESS(403, "게시글에 대한 권한이 없습니다."),
    DUPLICATE_LIKE(409, "이미 좋아요를 눌렀습니다."),
    NOT_LIKED(400, "좋아요를 누르지 않았습니다."),

    /* Comment */
    COMMENT_NOT_FOUND(404, "댓글을 찾을 수 없습니다."),
    UNAUTHORIZED_COMMENT_ACCESS(403, "댓글에 대한 권한이 없습니다."),

    /* Chat */
    CHAT_ROOM_NOT_FOUND(404, "채팅방을 찾을 수 없습니다."),
    UNAUTHORIZED_CHAT_ACCESS(403, "채팅에 대한 권한이 없습니다."),

    /* Story */
    STORY_NOT_FOUND(404, "스토리를 찾을 수 없습니다."),
    UNAUTHORIZED_STORY_ACCESS(403, "스토리에 대한 권한이 없습니다."),

    /* Profile */
    PROFILE_NOT_FOUND(404, "프로필을 찾을 수 없습니다."),
    UNAUTHORIZED_PROFILE_ACCESS(403, "프로필에 대한 권한이 없습니다."),

    /* Search */
    SEARCH_KEYWORD_REQUIRED(400, "검색어를 입력해 주세요."),
    SEARCH_RESULT_NOT_FOUND(404, "검색 결과가 없습니다."),

    /* Admin */
    ADMIN_ONLY(403, "관리자만 접근할 수 있습니다."),
    USER_ALREADY_BLOCKED(409, "이미 차단된 사용자입니다."),
    USER_NOT_BLOCKED(400, "차단되지 않은 사용자입니다."),

    /* File */
    FILE_EXTENSION_INVALID(400, "파일 확장자가 유효하지 않습니다."),
    FILE_UPLOAD_FAILED(500, "파일 업로드에 실패했습니다."),
    FILE_NOT_FOUND(404, "파일을 찾을 수 없습니다."),

    /* Server */
    INTERNAL_SERVER_ERROR(500, "서버 에러가 발생했습니다.");

    private final int status;
    private final String message;
}
