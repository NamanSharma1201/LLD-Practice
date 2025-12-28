package FileManager;

import FileManager.fileIO.LocalFileIO;
import FileManager.manager.FileManager;
import FileManager.service.FileEventNotifier;
import FileManager.service.notification.FileUpdatesObserver;
import FileManager.service.notification.decorator.FileUpdatesSmsDecoratorObserver;
import FileManager.service.notification.decorator.FilesUpdatesEmailDecoratorObserver;

import java.util.Arrays;


public class App {

    public static void main(String[] args) throws Exception {

       FileManager fileManager = new FileManager(new LocalFileIO());
       FileEventNotifier.getInstance().addObserver(new FileUpdatesSmsDecoratorObserver(new FilesUpdatesEmailDecoratorObserver(new FileUpdatesObserver())));
       String content = "Hi! my name is Naman.";
        fileManager.upload("./message.txt", content.getBytes());
        System.out.println(Arrays.toString(fileManager.download("./message.txt")));

    }

    
}

