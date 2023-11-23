package F12.newsfeedproject.global.exception.board;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class BoardNotFoundException extends BusinessException {

  public BoardNotFoundException() {
    super(ErrorCode.BOARD_NOT_FOUND_EXCEPTION);
  }
}
