package app.collections.my_json_parser2json;

/**
 * Created by 1 on 13.06.2017.
 */
public class DoubleValue extends Value {
    private double value;

    public DoubleValue(String s) {
        value = Double.parseDouble(s);
    }

    public double getValue() {
        return value;
    }
}
