package Project;

import Project.Metrics.MetricsCPU.MetricsCPU;

/**
 * 1. Реализовать много поточность.
 * 2. Переключение между потоками.
 * 3.
 *
 * Полезно:
 * 1. https://habrahabr.ru/post/164487/
 * 2.
 */
public class Test {
    private int lenght = 100;

    public static void main(String[] args) {

        MetricsCPU testt = new MetricsCPU();
        testt.get();
        Test test = new Test();
        System.out.println(test.lenght);

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                Test test = new Test();
                test.printX();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                Test test = new Test();
                test.printY();
            }
        });
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                Test test = new Test();
                test.printZ();
            }
        });
        thread3.start();

        Thread thread4 = new Thread(new Runnable() {
            public void run() {
                Test test = new Test();
                test.printD();
            }
        });
        thread4.start();

    }

    private void printX(){
        for(int i = 0; i < this.lenght; i++){
            System.out.print("X");
        }
    }

    private void printY(){
        for(int i = 0; i < this.lenght; i++){
            System.out.print("Y");
        }
    }

    private void printZ(){
        for(int i = 0; i < this.lenght; i++){
            System.out.print("Z");
        }
    }

    private void printD(){
        for(int i = 0; i < this.lenght; i++){
            System.out.print("D");
        }
    }
}
