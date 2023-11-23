package F12.newsfeedproject.global.exception.member;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class UnAuthorizedModifyException extends BusinessException {

  public UnAuthorizedModifyException() {
    super(ErrorCode.UNAUTHORIZED_MODIFY_EXCEPTION);
  }
}
