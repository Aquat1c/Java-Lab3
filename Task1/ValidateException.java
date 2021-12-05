package Task1;

public class ValidateException extends Exception {
    private final ErrorCode errorCode;

    public ValidateException(final String message, final ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
