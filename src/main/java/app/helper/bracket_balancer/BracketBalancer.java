package app.helper.bracket_balancer;

import app.helper.bracket_balancer.bracket.Bracket;

import java.util.Stack;

import static app.helper.bracket_balancer.Constants.brackets;

public class BracketBalancer {
    BracketBalancer() {

    }

    public static boolean haveBalance(String s) throws BracketException {
        boolean ok = true;

        Stack<Bracket> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (brackets.contains(s.charAt(i))) {
                Bracket bracket = BracketFactory.getBracket(i, s.charAt(i));
                if (!bracket.getIsClose()) {
                    stack.push(bracket);
                } else {
                    if (bracket.getType().equals(stack.peek().getType())) {
                        stack.pop();
                    } else {
                        ok = false;
                        break;
                    }
                }
            }
            /*if (brackets.contains(s.charAt(i))) {
                stack.push(BracketFactory.getBracket(i, s.charAt(i)));
            }*/
        }

        return ok;
    }
}
