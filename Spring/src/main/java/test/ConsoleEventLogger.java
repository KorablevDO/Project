package test;

public class ConsoleEventLogger implements EventLogger{

    public void get(String message) {
        System.out.println(message);
    }
}
