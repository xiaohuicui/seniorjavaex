package ex1;


public class SeniorPrinterDevice extends PrinterDevice implements SeniorOutput {

    private int leftInk = MAX_INK;

    @Override
    public void chargeInk() {
        leftInk = MAX_INK;
        System.out.println("Charging INK!");

    }

    @Override
    public int consumeInk(String msg) {
        return msg.length()*3;

    }


    @Override
    public boolean inputData(String msg) {
        if ((dataNum >= MAX_CACHE_LINE)||leftInk<consumeInk(msg)){
            System.out.println("CACHELINE is FULL! or Left Ink is not enough");
            return false;
        }else{
            printData[dataNum++] = msg;
            leftInk -= consumeInk(msg);
            return true;
        }

    }

    public static void main(String[] args){
        SeniorOutput od = new SeniorPrinterDevice();
        String[] taskList = new String[]{"Tast1","Task2","Task3","Tast4","Task5"};
        for(String task:taskList){
            if(od.inputData(task)){
                od.out();
            }else if(od.consumeInk(task)> MAX_INK){
                System.out.println(task + "is too big to print!");
            }else{
                od.chargeInk();
                od.inputData(task);
                od.out();
            }
        }


    }
}
