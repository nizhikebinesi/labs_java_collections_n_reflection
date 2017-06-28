package app.collections.my_json_parser.states;

/**
 * Created by 1 on 14.06.2017.
 */
public enum State {
    START, END,
    OBJECT_START, OBJECT_END,
    ARRAY_START, ARRAY_END,
    KEY, COLON, COMMA,
    BEFORE_START, ERROR;
}
