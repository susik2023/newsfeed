package F12.newsfeedproject.global.exception.like;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class DuplicatedLikeException extends BusinessException {
    public DuplicatedLikeException() {
        super(ErrorCode.DUPLICATED_LIKE_EXCEPTION);
    }
}