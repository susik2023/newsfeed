package F12.newsfeedproject.global.exception.like;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class NotFoundLikeException extends BusinessException {
    public NotFoundLikeException() {
        super(ErrorCode.NOT_FOUND_LIKE_EXCEPTION);
    }
}