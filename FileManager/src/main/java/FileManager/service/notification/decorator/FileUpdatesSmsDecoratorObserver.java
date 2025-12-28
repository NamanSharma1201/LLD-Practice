package FileManager.service.notification.decorator;

import FileManager.service.notification.IfileObserver;

public class FileUpdatesSmsDecoratorObserver extends FilesUpdatesDecoratorObserver{
    public FileUpdatesSmsDecoratorObserver(IfileObserver observer) {
        super(observer);
    }
    @Override
    public void update(String event){
        super.update(event);
        System.out.println(" Send a SMS");
    }
}
