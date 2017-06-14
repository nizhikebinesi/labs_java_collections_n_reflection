package app.collections.my_json_parser.special_symbols;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 14.06.2017.
 */
public final class SpecialSymbols {
    public final static Set<Character> spaceSet;
    public final static char quote = '"';
    public final static char colon = ':';
    public final static char objectStart = '{';
    public final static char objectEnd = '}';
    public final static char arrayStart = '[';
    public final static char arrayEnd = ']';
    public final static char comma = ',';

    static {
        Character[] symbolsArray = {
                '\n',
                ' ',
                '\t',
                '\r'
        };

        spaceSet = new HashSet<>(Arrays.asList(symbolsArray));
    }
}
