package FileManager.fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import FileManager.service.FileEventNotifier;

public class LocalFileIO implements IfileIOStrategy {

    @Override
    public void saveFile(String filePath, byte[] data) {
        if (data == null) {
            System.err.println("Cannot save null data to path: " + filePath);
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data);
            FileEventNotifier.getInstance().notifyObservers("Your file has been saved");
        } catch (IOException e) {
            System.err.println("Not able to save file at path: " + filePath);
        }
    }

    @Override
    public byte[] readFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            return new byte[0];
        }

        try (FileInputStream fin = new FileInputStream(file)) {
            FileEventNotifier.getInstance().notifyObservers("Your file has been read");

            return fin.readAllBytes();
        } catch (IOException e) {
            System.err.println("Not able to read the file at path: " + filePath);
            return new byte[0];
        }
    }

    @Override
    public void deleteFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            return;
        }

        if (!file.delete()) {
            System.err.println("Failed to delete the file at path: " + filePath);
            return;
        }
        FileEventNotifier.getInstance().notifyObservers("Your file has been deleted");
        
    }

    @Override
    public boolean findFile(String filePath) {
        return new File(filePath).exists();
    }
}
