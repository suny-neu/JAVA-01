package java0.conc0301.homework;

import java0.conc0303.tool.SemaphoreDemo;

import java.util.concurrent.Semaphore;

public class ThreadSemaphore {
    private static int value=0;
    private static Semaphore semaphore=new Semaphore(0);

    public static  void sum() throws InterruptedException {
        Caculate caculate= new Caculate();
        value=caculate.getSum();
    }

    public static int getSum(){
        return value;
    }

    public static void main(String[] args) throws InterruptedException {


        Thread t=new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    sum();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        semaphore.acquire();
        value=getSum();
        System.out.println(value);


    }

}
