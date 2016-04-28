package ex1;

import java.util.Arrays;


public class MaxProcess extends ProcessArrayAdapter{
    public double process(int[] target){
         return this.process(target,tar->{
            double max = 0.0f;
            if (tar.length == 0){
                System.out.println("The Array is Empty!");
            }else{
                Arrays.sort(tar);
                max = tar[tar.length-1];
            }
            return max;



        });
    }

    public static void main(String[] args){
        int[] target = new int[]{1,2,3,4,5,6};
        System.out.println(new MaxProcess().process(target));
    }
}
