package app.reflection.executable;

import app.collections.humans.Human;

/**
 * Created by 1 on 30.05.2017.
 */
public class ExecTwo implements Executable {
    String s;
    Human human = new Human("Vadim", "Sokolov", 123);

    @Override
    public void execute() {
        s = human.toString();
        System.out.println("ExecTwo");
    }
}
