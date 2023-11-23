package F12.newsfeedproject.global.exception.member;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class AlreadyUserExistException extends BusinessException {

  public AlreadyUserExistException(ErrorCode errorCode) {
    super(errorCode);
  }
}
