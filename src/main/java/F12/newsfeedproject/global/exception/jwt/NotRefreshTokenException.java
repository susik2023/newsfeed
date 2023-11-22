package F12.newsfeedproject.global.exception.jwt;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class NotRefreshTokenException extends BusinessException {
    public NotRefreshTokenException() {
        super(ErrorCode.NOT_REFRESH_TOKEN_EXCEPTION);
    }
}
