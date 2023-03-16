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
            Map<String, Object> resultMap = new TreeMap<>();
            if (!dataMap1.containsKey(key)) {
                resultMap.put("key", key);
                resultMap.put("status", "added");
                resultMap.put("newValue", dataMap2.get(key));
                result.add(resultMap);
            } else if (!dataMap2.containsKey(key)) {
                resultMap.put("key", key);
                resultMap.put("status", "deleted");
                resultMap.put("oldValue", dataMap1.get(key));
                result.add(resultMap);
            } else if (!(Objects.equals(dataMap2.get(key), dataMap1.get(key)))) {
                resultMap.put("key", key);
                resultMap.put("status", "changed");
                resultMap.put("oldValue", dataMap1.get(key));
                resultMap.put("newValue", dataMap2.get(key));
                result.add(resultMap);
            } else {
                resultMap.put("key", key);
                resultMap.put("status", "unchanged");
                resultMap.put("newValue", dataMap2.get(key));
                result.add(resultMap);
            }
        }
        return result;
    }
}
