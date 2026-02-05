package FileManager.Factory;

import FileManager.fileIO.IfileIOStrategy;
import FileManager.manager.FileManager;

import java.util.List;

public interface IFileManagementFactory {
   public FileManager createFileManager(String ioMethod, List<String> observerTypes) throws IllegalAccessException;
}
