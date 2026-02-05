package FileManager.Factory;

import FileManager.fileIO.IfileIOStrategy;
import FileManager.fileIO.LocalFileIO;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FileIOFactory {

    private static final Map<String, Supplier<IfileIOStrategy>> STRATEGIES_REGISTRY = new HashMap<>();

    static {
        STRATEGIES_REGISTRY.put("local", LocalFileIO::new);
    }

    public static IfileIOStrategy getFileIOStrategy(String method) throws Exception{
        if(method == null){
            throw new IllegalArgumentException("Storage method can not be null");
        }
        if(STRATEGIES_REGISTRY.containsKey(method)){
            return STRATEGIES_REGISTRY.get(method).get();
        }
        throw new IllegalArgumentException("Invalid IO method : " + method);
    }
}
