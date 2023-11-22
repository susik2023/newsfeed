package F12.newsfeedproject.global.exception.jwt;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class InvalidJwtTokenException extends BusinessException {

    public InvalidJwtTokenException() {
        super(ErrorCode.INVALID_JWT_TOKEN_EXCEPTION);
    }

    public InvalidJwtTokenException(Throwable cause) {
        super(ErrorCode.INVALID_JWT_TOKEN_EXCEPTION, cause);
    }
}
