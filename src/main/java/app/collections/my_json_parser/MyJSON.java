package app.collections.my_json_parser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 14.06.2017.
 */
public class MyJSON implements Value {
    private Map<String, Value> map;

    public MyJSON() {
        map = new HashMap<>();
    }

    /**
     *
     * @param key
     * @return value by key
     */
    public Value getFieldValue(String key) {
        return map.get(key);
    }

    /**
     * If pair <key, value> already is in map then old pair replaces by new pair
     * @param key
     * @param value
     */
    public void setFieldValue(String key, Value value) {
        map.put(key, value);
    }

    public void removeField(String key) {
        map.remove(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyJSON myJSON = (MyJSON) o;

        return map != null ? map.equals(myJSON.map) : myJSON.map == null;
    }
}
