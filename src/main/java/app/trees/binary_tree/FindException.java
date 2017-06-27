package app.trees.binary_tree;

/**
 * Created by 1 on 27.06.2017.
 */
public class FindException extends Exception {
    public FindException() {
    }

    public FindException(String message) {
        super(message);
    }

    public FindException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindException(Throwable cause) {
        super(cause);
    }

    public FindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
