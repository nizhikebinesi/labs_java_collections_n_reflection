package app.collections.my_json_parser2json;

import java.util.HashMap;

import static app.collections.my_json_parser2json.Constants.*;

public class MyJSON extends Value {
    HashMap<String, Value> map;

    public MyJSON(String object) {
        parseObject(object);
        /*int
                startOfObject = 0,
                endOfObject = 0,
                startOfArray = 0,
                endOfArray = 0
                //, objectCount = 0
                ;
        if (!(
                object.charAt(0) == objectStart
                &&
                object.charAt(object.length() - 1) == objectEnd
        )) {
            throw new IllegalArgumentException();
        }

        String name;
        Value value;
        Pair pair;

        int i = 1;

        boolean haveColon = true;



        for (i = 1; i < object.length() - 1; i++) {
            if (spaceSymbols.contains(object.charAt(i))) {
                continue;
            }
            getSpace(object, i);
            pair = getName(object, i);

            //getSpace();
            haveColon = getColon();
           // getSpace();
        }*/
    }

    private void parseObject(String s) {

    }

    class Pair {
        int end;
        String result;
    }

    private Pair getName(String object, int start) {
        Pair pair = new Pair();
        return pair;
    }

    private int getSpace(String object, int start) {
        return start;
    }

    private boolean getColon() {
        boolean ok = false;
        return ok;
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
