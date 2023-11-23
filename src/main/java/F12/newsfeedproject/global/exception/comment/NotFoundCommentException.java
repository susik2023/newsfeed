package F12.newsfeedproject.global.exception.comment;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class NotFoundCommentException extends BusinessException {
  public NotFoundCommentException() {
    super(ErrorCode.NOT_FOUND_COMMENT_EXCEPTION);
  }
}
