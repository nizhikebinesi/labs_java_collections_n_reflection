package app.collections.my_json_parser2json;

/**
 * Created by 1 on 13.06.2017.
 */
public class IntegerValue extends Value {
    private int value;

    public IntegerValue(String s) {
        value = Integer.parseInt(s);
    }

    public int getValue() {
        return value;
    }
}
