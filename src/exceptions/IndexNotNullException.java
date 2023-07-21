package exceptions;

public class IndexNotNullException extends RuntimeException{
    public IndexNotNullException() {
    }

    public IndexNotNullException(String message) {
        super(message);
    }

    public IndexNotNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexNotNullException(Throwable cause) {
        super(cause);
    }

    public IndexNotNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
