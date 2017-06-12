package app.reflection.executable;

import app.collections.humans.Human;

/**
 * Created by 1 on 30.05.2017.
 */
public class ExecTwo implements Executable {
    private String s;
    private Human human = new Human("Vadim", "Sokolov", 123);

    public String getS() {
        return s;
    }

    public Human getHuman() {
        return human;
    }

    @Override
    public void execute() {
        s = human.toString() + "; this is string!";
        System.out.println("ExecTwo");
    }
}
