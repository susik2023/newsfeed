package F12.newsfeedproject.global.exception.user;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class UserNotFoundException extends BusinessException {

  public UserNotFoundException() {
    super(ErrorCode.NOT_FOUND_MEMBER_EXCEPTION);
  }
}
