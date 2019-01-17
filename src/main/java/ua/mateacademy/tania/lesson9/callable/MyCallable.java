package ua.mateacademy.tania.lesson9.callable;

import java.util.concurrent.Callable;

/**
 * Created by Tania Nebesna on 16.01.2019.
 */
public class MyCallable implements Callable<CommonResource> {
    private CommonResource commonResource;
    private String name;

    public MyCallable(CommonResource commonResource, String name) {
        this.commonResource = commonResource;
        this.name = name;
    }

    @Override
    public CommonResource call() throws Exception {
        for (int i = 0; i < 5; i++) {
            commonResource.incrementValue();
            Thread.sleep(100);
        }
        System.out.println(name + " have finished");
        return commonResource;
    }
}
