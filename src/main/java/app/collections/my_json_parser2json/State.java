package app.collections.my_json_parser2json;

public enum State {
    UNKNOWN, COMMA,
    START, END,
    SPACE, NAME,
    NAME_START, NAME_END,
    COLON, VALUE,
    ARRAY_START, ARRAY_END,
    OBJECT_START, OBJECT_END;


}
