package java0.conc0301.homework;

import java.util.concurrent.atomic.AtomicInteger;


public class ThreadJoin {

    private static int value=0;

    public static  void sum(){
        Caculate caculate= new Caculate();
        value=caculate.getSum();
    }

    public static int getSum(){
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t=new Thread(() -> {
            sum();
        });
        t.start();
        //主线程的执行需要依赖t线程的处理结果，因此join获取t的执行结果
        t.join();

        value=getSum();
        System.out.println(value);
    }

}

