package F12.newsfeedproject.global.exception.jwt;


import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class ExpiredJwtTokenException extends BusinessException {

    public ExpiredJwtTokenException() {
        super(ErrorCode.EXPIRED_JWT_TOKEN_EXCEPTION);
    }

    public ExpiredJwtTokenException(Throwable cause) {
        super(ErrorCode.EXPIRED_JWT_TOKEN_EXCEPTION, cause);
    }
}
