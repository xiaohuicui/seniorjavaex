package ex1;


public interface SeniorOutput extends OutputDevice{
    int MAX_INK = 30;
    void chargeInk();
    int consumeInk(String msg);
}
