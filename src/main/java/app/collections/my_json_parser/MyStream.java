package app.collections.my_json_parser;

import app.collections.my_json_parser.special_symbols.SpecialSymbols;

/**
 * Created by 1 on 14.06.2017.
 */
public class MyStream {
    private String s;
    private int index = 0;
    private int size;

    public MyStream(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        this.s = s;
        size = s.length();
    }

    public char read() throws StringIndexOutOfBoundsException {
        while (SpecialSymbols.spaceSet.contains(s.charAt(index))) {
            next();
        }
        return s.charAt(index);
    }

    public void next() throws StringIndexOutOfBoundsException {
        if (!hasNext()) {
            throw new StringIndexOutOfBoundsException("In next():\n" + "s = " + s + "; index = " + index);
        }
        index++;
    }

    public boolean hasNext() {
        return (index < size);
    }
}
