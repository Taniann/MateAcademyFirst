package ua.mateacademy.tania.patterns.proxy;

public class RealFile implements File{

    private String fileName;

    public RealFile(String fileName) {
        this.fileName = fileName;
        load(fileName);
    }

    @Override
    public void execute() {
        System.out.println("Executing " + fileName);
    }

    private void load(String fileName) {
        System.out.println("Loading " + fileName);
    }
}
