package F12.newsfeedproject.global.exception.comment;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class RejectedExecutionException extends BusinessException {
  public RejectedExecutionException() {
    super(ErrorCode.REJECTED_EXCUTION_EXCEPTION);
  }
}
