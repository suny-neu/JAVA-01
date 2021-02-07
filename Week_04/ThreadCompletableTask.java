package java0.conc0301.homework;

import java.util.concurrent.CompletableFuture;

public class ThreadCompletableTask {
    private  static int value=0;
    private static Caculate caculate=new Caculate();

    public static void main(String[] args) {
        Integer result = CompletableFuture.supplyAsync(() -> caculate.getSum()).join();
        System.out.println(result);
    }
}
