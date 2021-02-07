package java0.conc0301.homework;

import java.util.concurrent.CountDownLatch;

public class ThreadCountDownLatch {
    private static int value=0;
    public static  void sum(){
        Caculate caculate= new Caculate();
        value=caculate.getSum();
    }

    public static int getSum(){
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch  latch=new CountDownLatch(1);
        Thread t=new Thread(()->{
            sum();
            latch.countDown();
        });
        t.start();
        latch.await();
        value=getSum();
        System.out.println(value);




    }
}
