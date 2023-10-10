package utils;

import java.util.HashMap;
import java.util.Map;

public class DataStorage {
    private static final Map<String, Object> dataStorage = new HashMap<>();

    public static void addData(String key, Object value) {
        dataStorage.put(key, value);
    }

    public static Object getData(String key) {
        return dataStorage.get(key);
    }

    public static void clearData() {
        dataStorage.clear();
    }
}
