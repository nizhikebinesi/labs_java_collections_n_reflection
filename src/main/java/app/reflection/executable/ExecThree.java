package app.reflection.executable;

/**
 * Created by 1 on 30.05.2017.
 */
public class ExecThree implements Executable {
    private double a = 42.42;

    public double getA() {
        return a;
    }

    @Override
    public void execute() {
        a = 0;
        System.out.println("ExecThree");
        //System.out.println("Holy Execute!");
    }
}
