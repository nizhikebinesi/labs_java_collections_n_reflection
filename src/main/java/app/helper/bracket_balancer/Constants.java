package app.helper.bracket_balancer;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public final class Constants {
    public final static Set<Character> brackets;
    public final static Set<Character> braces;
    public final static Set<Character> squareBrackets;
    public final static Set<Character> roundBrackets;
    public final static Set<Character> triangularBrackets;
    public final static Set<Character> quotes;
    public final static Set<Character> open;
    public final static Set<Character> close;

    static {
        Character[] bracesArr = {'{','}'};
        Character[] squareBracketsArr = {'[', ']'};
        Character[] roundBracketsArr = {'(', ')'};
        Character[] triangularBracketsArr = {'<', '>'};
        Character[] quotesArr = {'"'};
        Character[] openArr = {'(', '{', '[', '<', '"'};
        Character[] closeArr = {')', '}', ']', '>', '"'};

        braces = new HashSet<>(asList(bracesArr));
        squareBrackets = new HashSet<>(asList(squareBracketsArr));
        roundBrackets = new HashSet<>(asList(roundBracketsArr));
        triangularBrackets = new HashSet<>(asList(triangularBracketsArr));
        quotes = new HashSet<>(asList(quotesArr));
        open = new HashSet<>(asList(openArr));
        close = new HashSet<>(asList(closeArr));

        brackets = new HashSet<>();
        brackets.addAll(braces);
        brackets.addAll(squareBrackets);
        brackets.addAll(roundBrackets);
        //brackets.addAll(triangularBrackets);
        brackets.addAll(quotes);
    }
}
