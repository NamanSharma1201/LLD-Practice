package FileManager.service;

import java.util.ArrayList;
import java.util.List;

import FileManager.service.notification.IfileObserver;

public class FileEventNotifier {

    private static FileEventNotifier instance;

    public static FileEventNotifier getInstance() {
        if (instance == null) {
            instance = new FileEventNotifier();
        }
        return instance;
    }

    private final List<IfileObserver> observers;

    private FileEventNotifier() {
        observers = new ArrayList<>();
    }

    public void addObserver(IfileObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void removeObserver(IfileObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String event) {
        for (IfileObserver observer : observers) {
            observer.update(event);
        }
    }
}
