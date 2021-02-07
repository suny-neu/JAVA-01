package java0.conc0301.homework;

import java.util.concurrent.locks.LockSupport;

public class ThreadLockSupport {
    private static int value=0;
    public static  void sum(){
        Caculate caculate= new Caculate();
        value=caculate.getSum();
    }

    public static int getSum(){
        return value;
    }


    public static void main(String[] args) {
        Thread main=Thread.currentThread();
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            sum();
            LockSupport.unpark(main);
        });
        t1.start();

        value=getSum();
        LockSupport.park();
        System.out.println(value);


    }

    static class SumThread implements Runnable{

        @Override
        public void run() {
            System.out.println("开始线程阻塞");
            sum();
            LockSupport.unpark(Thread.currentThread());
            System.out.println("结束线程阻塞");
        }
    }

//    static class Thread implements Runnable{
//
//        @Override
//        public void run() {
//            System.out.println("开始线程阻塞");
//            getSum();
//            System.out.println("结束线程阻塞");
//        }
//    }
}

//class MyThread extends Thread{
//    @Override
//    public void run() {
//        super.run();
//    }
//}
