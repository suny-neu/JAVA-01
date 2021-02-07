package java0.conc0301.homework;


import java.util.concurrent.atomic.AtomicInteger;

public class ThreadWaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        Caculate caculate=new Caculate();
        AtomicInteger sum= new AtomicInteger();
        Thread t=new Thread(()->{
            synchronized (sum) {
                sum.set(caculate.getSum());
                sum.notify();
            }
        });
        t.start();

        synchronized (sum) {
            sum.wait();
            System.out.println(sum.getAndAdd(2));
        }
    }
}


