package hexlet.code;

import java.util.Map;

public class Formatter {
    // getting the comparison result in the required format
    public static String stylish(Map<String, String> dataForFormat, Map<String, Object> dataMap1,
                                 Map<String, Object> dataMap2) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map.Entry<String, String> elem : dataForFormat.entrySet()) {
            if (elem.getValue().equals("added")) {
                result.append(" + ").append(elem.getKey()).append(": ")
                        .append(dataMap2.get(elem.getKey())).append("\n");
            } else if (elem.getValue().equals("deleted")) {
                result.append(" - ").append(elem.getKey()).append(": ")
                        .append(dataMap1.get(elem.getKey())).append("\n");
            } else if (elem.getValue().equals("changed")) {
                result.append(" - ").append(elem.getKey()).append(": ")
                        .append(dataMap1.get(elem.getKey())).append("\n")
                        .append(" + ").append(elem.getKey()).append(": ")
                        .append(dataMap2.get(elem.getKey())).append("\n");
            } else {
                result.append("   ").append(elem.getKey()).append(": ")
                        .append(dataMap2.get(elem.getKey())).append("\n");
            }
        }
        result.append("}\n");
        return result.toString();
    }
}
