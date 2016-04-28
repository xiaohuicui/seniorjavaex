package ex1;


public class AVGCommand implements Command {

    @Override
    public double process(int[] target){
        double avg = 0.0;
        if(target.length == 0){
            System.out.println("Target Array is empty");
        }else {
            Command sumCommand = new SUMCommand();
            double sum = sumCommand.process(target);
            avg = sum / target.length;
        }
        return avg;
    }
}
