package app.reflection.executable;


public class ExecOne implements Executable {
    private int a = 42;

    @Override
    public void execute() {
        System.out.println("ExecOne");
        a = -21;
    }
}
