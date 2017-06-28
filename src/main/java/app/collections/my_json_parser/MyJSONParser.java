package app.collections.my_json_parser;

import app.collections.my_json_parser.exceptions.ParseMyJSONException;
import app.collections.my_json_parser.states.State;

/**
 * Created by 1 on 14.06.2017.
 */
public class MyJSONParser {
    MyJSON myJSON = new MyJSON();
    String key = "";

    public static void parse(char symbol, State state) {

    }

    public static void parseStart(MyStream stream) throws ParseMyJSONException {

        State state = State.BEFORE_START;
        char symbol;
        while (stream.hasNext()) {
            try {
                symbol = stream.read();
                parse(symbol, state);
            } catch (StringIndexOutOfBoundsException e) {
                throw new ParseMyJSONException();
            }
        }
        /*if (symbol == SpecialSymbols.objectStart) {
            state = State.START;
        } else {
            state = State.ERROR;
        }*/
    }
}
