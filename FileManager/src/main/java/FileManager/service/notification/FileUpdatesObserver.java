package FileManager.service.notification;

public class FileUpdatesObserver implements IfileObserver{
    @Override
    public void update(String event){
        System.out.println("Event Occured :: " + event);
    }
}
