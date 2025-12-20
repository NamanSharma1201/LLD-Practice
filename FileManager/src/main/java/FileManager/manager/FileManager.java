package FileManager.manager;

import FileManager.fileIO.IfileIOStrategy;

public class FileManager {
    private IfileIOStrategy strategy;
    public FileManager(IfileIOStrategy strategy){
        this.strategy = strategy;
    }
    public void setStrategy(IfileIOStrategy strategy){
        this.strategy = strategy;
    }
    
    public void upload(String filePath, byte[] data){
        strategy.saveFile(filePath, data);
    }
    public byte[] download(String filePath){
        return strategy.readFile(filePath);
    }
}
