package F12.newsfeedproject.global.exception.jwt;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class FailedAuthenticationException extends BusinessException {

    public FailedAuthenticationException() {
        super(ErrorCode.FAILED_AUTHENTICATION_EXCEPTION);
    }

    public FailedAuthenticationException(Throwable cause) {
        super(ErrorCode.FAILED_AUTHENTICATION_EXCEPTION, cause);
    }
}
