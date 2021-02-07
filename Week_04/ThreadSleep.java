package java0.conc0301.homework;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger sum= new AtomicInteger(0);
        Caculate caculate= new Caculate();
        Thread t=new Thread(() -> {
            sum.set(caculate.getSum());
        });
        t.start();

        Thread.currentThread().sleep(20);
        System.out.println(sum.get());
    }
}
