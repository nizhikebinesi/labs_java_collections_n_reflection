package app.collections.my_json_parser.exceptions;

/**
 * Created by 1 on 14.06.2017.
 */
public class ParseMyJSONException extends Exception {
    public ParseMyJSONException() {
    }

    public ParseMyJSONException(String message) {
        super(message);
    }

    public ParseMyJSONException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseMyJSONException(Throwable cause) {
        super(cause);
    }

    public ParseMyJSONException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
