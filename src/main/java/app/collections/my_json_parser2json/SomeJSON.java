package app.collections.my_json_parser2json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SomeJSON extends Value {

    private HashMap<String, Value> map;
    private State state;

    public SomeJSON(String s) {
        parseJSON(s);
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

    private static Set<State> permissibleSet4Name = new HashSet<>();

    static {
        State[] arr = {
                State.START,
                State.COMMA,
                State.OBJECT_START,
                State.ARRAY_END,
        };

        permissibleSet4Name.addAll(Arrays.asList(arr));
    }

    private void parseJSON(String s) {
        int index = 0;
        state = State.UNKNOWN;//State.START;
        while (state != State.END) {
            if ((index == 0) && (s.charAt(index) == Constants.objectStart) && (state == State.UNKNOWN)) {
                state = State.START;
            } else
            if ((index == s.length() - 1) && (s.charAt(index) == Constants.objectEnd)) {
                state = State.END;
            } else
            if ((s.charAt(index) == Constants.nameStartEnd) && (permissibleSet4Name.contains(state))) {

            }
            index++;
        }
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

    public void setValueOfField(String fieldName, Value value) {
        map.put(fieldName, value);
    }

    public void removeField(String fieldName) {
        map.remove(fieldName);
    }
}
