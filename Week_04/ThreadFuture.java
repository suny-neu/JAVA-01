package java0.conc0301.homework;

import java.util.concurrent.*;

public class ThreadFuture {
    private static int value=0;
    private static Caculate caculate=new Caculate();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long time=System.currentTimeMillis();
        ExecutorService executorService= Executors.newCachedThreadPool();
        FutureTask futureTask= (FutureTask) executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return caculate.getSum();
            }
        });
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-time);
        System.out.println(futureTask.get());
    }
}
