package F12.newsfeedproject.global.exception.follow;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class DuplicatedFollowException extends BusinessException {
    public DuplicatedFollowException() {
        super(ErrorCode.DUPLICATED_FOLLOW_EXCEPTION);
    }
}