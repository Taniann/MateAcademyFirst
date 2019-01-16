package ua.mateacademy.tania.lesson9.executor;

/**
 * Created by Tania Nebesna on 15.01.2019.
 */
public class CountThread implements Runnable{
    private CommonResource commonResource;
    private String name;

    public CountThread(CommonResource commonResource, String name) {
        this.commonResource = commonResource;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " waiting");
            for (int i = 0; i < 5; i++) {
                commonResource.incrementValue();
                System.out.println(name + ": " + commonResource.getValue());
                Thread.sleep(100);
            }
        }catch (InterruptedException ex) {
        }
    }
}
