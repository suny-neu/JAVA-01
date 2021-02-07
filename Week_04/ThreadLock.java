package java0.conc0301.homework;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock {

    private static Lock lock=new ReentrantLock();
    private static Condition condition=lock.newCondition();
    private static int value=0;

    public  static  void sum(){
        lock.lock();
        condition.signal();
        try {
            Caculate caculate = new Caculate();
            value = caculate.getSum();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static int getSum() throws InterruptedException {
        lock.lock();
        try{
            while(value==0){
                condition.await();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
       return value;
    }

    public static void main(String[] args) throws InterruptedException {
       Thread t=new Thread(()->{
           sum();
       });
       t.start();
      int result= getSum();
      System.out.println(result);

    }



}
