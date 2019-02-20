package ua.mateacademy.tania.patterns.proxy;

public class ProxyPatternApp {
    public static void main(String[] args) {
        File file = new RealFile("name");

        File fileWithProxy = new ProxyFile("fileName");
        fileWithProxy.execute();
    }
}
