package F12.newsfeedproject.global.exception.jwt;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class NoJwtException extends BusinessException {

  public NoJwtException() {
    super(ErrorCode.NO_JWT_EXCEPTION);
  }
}
