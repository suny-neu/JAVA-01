package java0.conc0301.homework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ThreadCyclicBarrier {

    private static int value=0;
    public static  void sum(){
        Caculate caculate= new Caculate();
        value=caculate.getSum();
    }

    public static int getSum(){
        return value;
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        //需要两个线程
    CyclicBarrier  cyclicBarrier=new CyclicBarrier(1, new Runnable() {
        @Override
        public void run() {
            //两个线程到跑完执行这个
            System.out.println(value);
        }
     });
        Thread t=new Thread(()->{
            sum();
        });
        t.start();

        Thread.sleep(100);
        cyclicBarrier.await();
        value=getSum();
    }



}
