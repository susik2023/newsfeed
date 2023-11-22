package F12.newsfeedproject.global.exception.jwt;

import F12.newsfeedproject.global.exception.common.BusinessException;
import F12.newsfeedproject.global.exception.common.ErrorCode;

public class InvalidJwtSignatureException extends BusinessException {

    public InvalidJwtSignatureException() {
        super(ErrorCode.INVALID_JWT_SIGNATURE_EXCEPTION);
    }

    public InvalidJwtSignatureException(Throwable cause) {
        super(ErrorCode.INVALID_JWT_SIGNATURE_EXCEPTION, cause);
    }
}
