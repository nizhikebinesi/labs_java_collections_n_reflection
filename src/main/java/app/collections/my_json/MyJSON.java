package app.collections.my_json;

import java.util.HashMap;

public class MyJSON extends Value {
    HashMap<String, Value> map;

    public MyJSON(String object) {

        //super();
    }

    private Value parseField() {
        return null;
    }

    public Value getValueOfField(String fieldName) {
        return map.get(fieldName);
    }

    /*public void setValueOfField(String fieldName, Value value) {
        map.put(fieldName, value);
    }*/

    public void removeField(String fieldName) {
        map.remove(fieldName);
    }
}
