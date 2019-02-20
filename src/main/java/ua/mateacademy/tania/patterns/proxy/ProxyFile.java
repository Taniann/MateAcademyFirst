package ua.mateacademy.tania.patterns.proxy;

public class ProxyFile implements File {
    private RealFile realFile;
    private String fileName;

    public ProxyFile(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        if(realFile == null){
            realFile = new RealFile(fileName);
        }
        realFile.execute();
    }
}
