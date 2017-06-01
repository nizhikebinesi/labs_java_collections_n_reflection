package app.collections.my_json;

/**
 * Created by 1 on 12.05.2017.
 */
public abstract class Value {
    private final String type;

    protected Value(String type) {
        this.type = type;
    }
}
