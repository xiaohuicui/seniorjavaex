package ex1;

public interface OutputDevice {
    int MAX_CACHE_LINE = 50;
    void out();
    boolean inputData(String msg);
}