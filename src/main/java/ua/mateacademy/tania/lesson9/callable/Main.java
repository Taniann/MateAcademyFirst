package ua.mateacademy.tania.lesson9.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Tania Nebesna on 16.01.2019.
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonResource commonResource = new CommonResource(0);

        MyCallable callable1 = new MyCallable(commonResource, "callable-1");
        MyCallable callable2 = new MyCallable(commonResource, "callable-2");
        MyCallable callable3 = new MyCallable(commonResource, "callable-3");

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<CommonResource> future1 = executorService.submit(callable1);
        Future<CommonResource> future2 = executorService.submit(callable2);
        Future<CommonResource> future3 = executorService.submit(callable3);

        System.out.println(future1.get().getValue());
        System.out.println(future2.get().getValue());
        System.out.println(future3.get().getValue());

        executorService.shutdown();


    }
}
