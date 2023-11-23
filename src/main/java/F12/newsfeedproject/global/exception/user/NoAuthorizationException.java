package F12.newsfeedproject.global.exception.user;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class NoAuthorizationException extends BusinessException {

  public NoAuthorizationException() {
    super(ErrorCode.NO_AUTHORIZATION_EXCEPTION);
  }
}
