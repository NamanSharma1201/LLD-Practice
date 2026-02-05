package FileManager;

import FileManager.Factory.FileIOFactory;
import FileManager.Factory.FileManagementFactoryImpl;
import FileManager.Factory.IFileManagementFactory;
import FileManager.fileIO.IfileIOStrategy;
import FileManager.manager.FileManager;
import FileManager.service.FileEventNotifier;
import FileManager.service.notification.FileUpdatesObserver;
import FileManager.service.notification.decorator.FileUpdatesSmsDecoratorObserver;
import FileManager.service.notification.decorator.FilesUpdatesEmailDecoratorObserver;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;


public class App {

    public static void main(String[] args)  {
        String storageType = "local";
        List<String> notificationChannels = Arrays.asList("Email", "SMS");

        IFileManagementFactory factory = new FileManagementFactoryImpl();

        try{
            FileManager fileManager = factory.createFileManager(storageType, notificationChannels);
            String content = "Hi! my name is Naman.";
            fileManager.upload("./message.txt", content.getBytes(StandardCharsets.UTF_8));
            System.out.println("Upload successful.");
        }catch (IllegalAccessException ex){
            System.err.println("Configuration Error : " + ex.getMessage());
        }catch (Exception ex){
            System.err.println("System Error : " + ex.getMessage());

        }


    }

    
}

