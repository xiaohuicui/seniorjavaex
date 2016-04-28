package ex1;


public class OutputFactory {
    public OutputDevice getOutput(){
        return new PrinterDevice();
    }
    public static void main(String[] args){
        OutputFactory of = new OutputFactory();
        OutputDevice od = of.getOutput();
        od.inputData("first task!");
        od.out();
    }
}



