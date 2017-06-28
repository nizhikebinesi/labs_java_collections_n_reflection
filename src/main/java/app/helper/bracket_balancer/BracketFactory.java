package app.helper.bracket_balancer;


import app.helper.bracket_balancer.bracket.Bracket;

import static app.helper.bracket_balancer.BracketType.*;
import static app.helper.bracket_balancer.Constants.*;

public abstract class BracketFactory {
    public static Bracket getBracket(int index, char ch) throws BracketException {
        Bracket bracket = new Bracket();

        bracket.setIndex(index);

        bracket.setClose(open.contains(ch));

        try {
            bracket.setType(knowKindOfBracketType(ch));
        } catch (BracketException e) {
            // add information about index
            throw new BracketException("Index of ch " + ch + " = " + index, e);
            //e.printStackTrace();
        }

        return bracket;
    }

    private static BracketType knowKindOfBracketType(char ch) throws BracketException {
        /*if (triangularBrackets.contains(ch)) {
            return TRIANGULAR;
        }*/
        if (braces.contains(ch)) {
            return BRACE;
        } else if (roundBrackets.contains(ch)) {
            return ROUND;
        } else if (squareBrackets.contains(ch)) {
            return SQUARE;
        } else if (quotes.contains(ch)) {
            return QUOTE;
        } else {
            throw new BracketException();
        }
    }
}
