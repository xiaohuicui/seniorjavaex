package ex1;


public class ProcessArrayAdapter implements ProcessArray {
    @Override
    public double process(int[] target, Command cmd) {
        return cmd.process(target);

    }
}
