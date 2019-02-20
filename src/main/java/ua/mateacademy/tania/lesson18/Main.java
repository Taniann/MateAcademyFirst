package ua.mateacademy.tania.lesson18;

public class Main {
    public static void main(String[] args) {
        SocksFactory socksFactory = FactoryProducer.getFactory("kyiv1");
        Socks socksOne = socksFactory.createSocks(null);
        System.out.println(socksOne);
    }
}
