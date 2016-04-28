package ex1;


public class SUMCommand implements Command {
    @Override
    public double process(int[] target) {
        double sum = 0.0;
        for(int tmp : target){
            sum += tmp;
        }
        return sum;
    }
}
