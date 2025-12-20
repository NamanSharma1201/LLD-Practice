package FileManager.fileIO;

public interface  IfileIOStrategy{
    public void saveFile(String filePath, byte[] data);
    public byte[] readFile(String filePath);
    public void deleteFile(String filePath);
    public boolean findFile(String filePath);
}