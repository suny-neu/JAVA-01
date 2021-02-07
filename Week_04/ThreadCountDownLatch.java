package java0.conc0301.homework;

import java.util.concurrent.CountDownLatch;

public class ThreadCountDownLatch {
    private static int value=0;
    private static Caculate caculate=new Caculate();

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch  latch=new CountDownLatch(1);
        Thread t=new Thread(()->{
            caculate.getSum();
            latch.countDown();
        });
        t.start();
        latch.await();
        value=caculate.returnSum();
        System.out.println(value);




    }
}
