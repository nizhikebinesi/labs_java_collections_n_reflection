package app.helper.bracket_balancer.bracket;

import app.helper.bracket_balancer.BracketType;


public class Bracket {
    boolean isClose;
    int index;
    BracketType type;

    public Bracket() {

    }

    public void setClose(boolean close) {
        isClose = close;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setType(BracketType type) {
        this.type = type;
    }

    public boolean getIsClose() {
        return isClose;
    }

    public int getIndex() {
        return index;
    }

    public BracketType getType() {
        return type;
    }
}
