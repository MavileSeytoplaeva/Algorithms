package exceptions;

public class StringNorFoundException extends RuntimeException {
    public StringNorFoundException() {
    }

    public StringNorFoundException(String message) {
        super(message);
    }

    public StringNorFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringNorFoundException(Throwable cause) {
        super(cause);
    }

    public StringNorFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
