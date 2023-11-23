package F12.newsfeedproject.global.exception.jwt;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class NotMisMatchedRefreshTokenException extends BusinessException {
    public NotMisMatchedRefreshTokenException() {
        super(ErrorCode.NOT_MISMATCHED_REFRESH_TOKEN_EXCEPTION);
    }
}
