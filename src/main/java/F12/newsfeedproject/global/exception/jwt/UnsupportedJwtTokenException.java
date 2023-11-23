package F12.newsfeedproject.global.exception.jwt;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class UnsupportedJwtTokenException extends BusinessException {
    public UnsupportedJwtTokenException() {
        super(ErrorCode.UNSUPPORTED_JWT_TOKEN_EXCEPTION);
    }

    public UnsupportedJwtTokenException(Throwable cause) {
        super(ErrorCode.UNSUPPORTED_JWT_TOKEN_EXCEPTION, cause);
    }
}
