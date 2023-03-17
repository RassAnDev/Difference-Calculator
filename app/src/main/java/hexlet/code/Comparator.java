package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Comparator {
    // comparing two files and finding differences
    public static List<Map<String, Object>> compare(Map<String, Object> dataMap1, Map<String, Object> dataMap2) {
        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> keys = new TreeSet<>(dataMap1.keySet());
        keys.addAll(dataMap2.keySet());

        for (String key : keys) {
            if (!dataMap1.containsKey(key)) {
                result.add(addMap(key, "added", "", dataMap2.get(key)));
            } else if (!dataMap2.containsKey(key)) {
                result.add(addMap(key, "deleted", dataMap1.get(key), ""));
            } else if (!(Objects.equals(dataMap2.get(key), dataMap1.get(key)))) {
                result.add(addMap(key, "changed", dataMap1.get(key), dataMap2.get(key)));
            } else {
                result.add(addMap(key, "unchanged", "", dataMap2.get(key)));
            }
        }
        return result;
    }

    private static Map<String, Object> addMap(Object key, Object status, Object oldValue, Object newValue) {
        Map<String, Object> result = new TreeMap<>();
        String stat = status.toString();

        switch (stat) {
            case "added":
            case "unchanged":
                result.put("key", key);
                result.put("status", status);
                result.put("newValue", newValue);
                break;
            case "deleted":
                result.put("key", key);
                result.put("status", status);
                result.put("oldValue", oldValue);
                break;
            case "changed":
                result.put("key", key);
                result.put("status", status);
                result.put("oldValue", oldValue);
                result.put("newValue", newValue);
                break;
            default:
                return result;
        }
//        result.put("key", key);
//        result.put("status", status);
//        result.put("oldValue", oldValue);
//        result.put("newValue", newValue);
        return result;
    }
//
//    private static Map<String, Object> addMapForNewValue(Object key, Object status, Object newValue) {
//        Map<String, Object> result = new TreeMap<>();
//        result.put("key", key);
//        result.put("status", status);
//        result.put("newValue", newValue);
//        return result;
//    }
//
//    private static Map<String, Object> addMapForOldValue(Object key, Object status, Object oldValue) {
//        Map<String, Object> result = new TreeMap<>();
//        result.put("key", key);
//        result.put("status", status);
//        result.put("oldValue", oldValue);
//        return result;
//    }
}
