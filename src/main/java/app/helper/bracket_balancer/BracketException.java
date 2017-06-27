package app.helper.bracket_balancer;

/**
 * Created by 1 on 19.06.2017.
 */
public class BracketException extends Exception {
    public BracketException() {
    }

    public BracketException(String message) {
        super(message);
    }

    public BracketException(String message, Throwable cause) {
        super(message, cause);
    }

    public BracketException(Throwable cause) {
        super(cause);
    }

    public BracketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
