package FileManager.service.notification.decorator;

import FileManager.service.notification.IfileObserver;

public abstract class FilesUpdatesDecoratorObserver implements IfileObserver {
    private  final IfileObserver observer;

    public FilesUpdatesDecoratorObserver(IfileObserver observer) {
        this.observer = observer;
    }

    @Override
    public void update(String event) {
        observer.update(event);
    }
}
