package ex1;

public class PrinterDevice implements OutputDevice{
    protected final String[] printData = new String[MAX_CACHE_LINE];
    protected int dataNum = 0;
    public void out(){
        while(dataNum > 0){
            System.out.println("Printing:"+printData[0]);
            System.arraycopy(printData,1,printData,0,--dataNum);
        }
    }
    public boolean inputData(String msg){
        if (dataNum >= MAX_CACHE_LINE){
            System.out.println("CACHELINE is FULL!");
            return false;
        }else{
            printData[dataNum++] = msg;
            return true;
        }
    }

    public static void main(String[] args){
        OutputDevice od = new PrinterDevice();
        od.inputData("First Task!");
        od.inputData("Second Task!");
        od.inputData("Third Task!");
        od.inputData("Forth Task!");
        od.out();
    }
}