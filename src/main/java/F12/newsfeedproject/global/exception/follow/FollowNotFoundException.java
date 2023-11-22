package F12.newsfeedproject.global.exception.follow;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class FollowNotFoundException extends BusinessException {
    public FollowNotFoundException(ErrorCode errorCode) {
        super(ErrorCode.NOT_FOUND_FOLLOW_EXCEPTION);
    }
}
