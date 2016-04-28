package ex1;


public class STDCommand implements Command {

    @Override
    public double process(int[] target) {
        double std = 0.0;
        if(target.length == 0){
            System.out.println("The Target Array is empty");
        }else{
            double tmpSum = 0.0;
            double avg = new AVGCommand().process(target);
            for(int tmp:target){
               tmpSum += Math.sqrt(Math.pow(tmp-avg,2));
            }
            std = tmpSum/(target.length-1);
        }
        return std;
    }

    public static void main(String[] args){
        int[] testArray = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(new STDCommand().process(testArray));
    }
}
