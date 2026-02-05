package FileManager.Factory;

import FileManager.fileIO.IfileIOStrategy;
import FileManager.manager.FileManager;
import FileManager.service.FileEventNotifier;
import FileManager.service.notification.FileUpdatesObserver;
import FileManager.service.notification.IfileObserver;
import FileManager.service.notification.decorator.FileUpdatesSmsDecoratorObserver;
import FileManager.service.notification.decorator.FilesUpdatesEmailDecoratorObserver;

import java.util.*;
import java.util.function.UnaryOperator;

public class FileManagementFactoryImpl implements IFileManagementFactory{
    private static final Map<String, UnaryOperator<IfileObserver>> DECORATOR_REGISTRY = new HashMap<>();

    static {
        DECORATOR_REGISTRY.put("SMS", FileUpdatesSmsDecoratorObserver::new);
        DECORATOR_REGISTRY.put("Email", FilesUpdatesEmailDecoratorObserver::new);
    }
    @Override
    public FileManager createFileManager(String ioMethod, List<String> observerTypes) throws Exception{
        IfileIOStrategy strategy1= FileIOFactory.getFileIOStrategy(ioMethod);
        IfileObserver compositeObserver = buildCompositeObserver(observerTypes);
        FileManager manager = new FileManager(strategy1);
        if(compositeObserver != null){
            FileEventNotifier.getInstance().addObserver(compositeObserver);
        }

        return manager;
    }
    private IfileObserver buildCompositeObserver(List<String> observerTypes){
        if(observerTypes == null || observerTypes.isEmpty()) return null;
        IfileObserver rootObserver = new FileUpdatesObserver();
        for(String type : observerTypes){
            if(!DECORATOR_REGISTRY.containsKey(type)){
                throw  new IllegalArgumentException("Unknown observer type : " + type );
            }

            rootObserver = DECORATOR_REGISTRY.get(type).apply(rootObserver);

        }

        return rootObserver;
    }

}
