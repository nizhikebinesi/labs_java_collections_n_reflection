package app.collections.my_json_parser2json;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Constants {
    public static char
            objectStart = '{',
            objectEnd = '}',
            arrayStart = '[',
            arrayEnd = ']',
            between = ':',
            comma = ',',
            newLine = '\n',
            space = ' ',
            specId = '_',
            nameStartEnd = '"';
    public static Set<Character>
            spaceSymbols;

    static {
        Character[] arr = {
                ' ',
                '\t',
                '\n',
                '\r'
        };

        spaceSymbols = new HashSet<>(Arrays.asList(arr));
    }
}
