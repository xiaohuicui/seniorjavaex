package ex1;


public class SumProcess extends ProcessArrayAdapter {
    public double process(int[] target){
         return this.process(target, new Command() {
            @Override
            public double process(int[] target) {
                double sum = 0.0;
                for(int tmp : target){
                    sum += tmp;
                }
                return sum;
            }
        });
    }

    public static void main(String args[]){
        int[] target = new int[]{1,2,3,4,5,6};
        System.out.println(new SumProcess().process(target));
    }
}
