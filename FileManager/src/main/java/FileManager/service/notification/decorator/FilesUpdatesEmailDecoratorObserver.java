package FileManager.service.notification.decorator;

import FileManager.service.notification.IfileObserver;

public class FilesUpdatesEmailDecoratorObserver extends FilesUpdatesDecoratorObserver{
    public FilesUpdatesEmailDecoratorObserver(IfileObserver observer) {
        super(observer);
    }

    @Override
    public void update(String event) {
        super.update(event);
        System.out.println( " Send an Email");
    }
}
