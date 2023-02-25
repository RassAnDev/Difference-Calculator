package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    // getting the comparison result in the plain format
    public static String format(Map<String, String> dataForFormat, Map<String, Object> dataMap1,
                                 Map<String, Object> dataMap2) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> elem : dataForFormat.entrySet()) {
            if (elem.getValue().equals("added")) {
                if (isComplexValue(dataMap2.get(elem.getKey()))) {
                    result.append("Property ").append("'").append(elem.getKey()).append("'")
                            .append(" was added with value: [complex value]").append("\n");
                } else if (isStringValue(dataMap2.get(elem.getKey()))) {
                    result.append("Property ").append("'").append(elem.getKey()).append("'")
                            .append(" was added with value: ").append("'").append(dataMap2.get(elem.getKey()))
                            .append("'").append("\n");
                } else {
                    result.append("Property ").append("'").append(elem.getKey()).append("'")
                            .append(" was added with value: ").append(dataMap2.get(elem.getKey())).append("\n");
                }
            } else if (elem.getValue().equals("deleted")) {
                result.append("Property ").append("'").append(elem.getKey()).append("'")
                        .append(" was removed").append("\n");
            } else if (elem.getValue().equals("changed")) {
                if (isComplexValue(dataMap1.get(elem.getKey())) && isComplexValue(dataMap2.get(elem.getKey()))) {
                    result.append("Property ").append("'").append(elem.getKey()).append("'")
                            .append(" was updated. From [complex value] to [complex value]").append("\n");
                } else if (isComplexValue(dataMap1.get(elem.getKey()))) {
                    result.append("Property ").append("'").append(elem.getKey()).append("'")
                            .append(" was updated. From [complex value] to ").append(dataMap2.get(elem.getKey()))
                            .append("\n");
                } else if (isComplexValue(dataMap2.get(elem.getKey()))) {
                    result.append("Property ").append("'").append(elem.getKey()).append("'")
                            .append(" was updated. From ").append(dataMap1.get(elem.getKey()))
                            .append(" to [complex value]").append("\n");
                } else if (isStringValue(dataMap1.get(elem.getKey())) && isStringValue(dataMap2.get(elem.getKey()))) {
                    result.append("Property ").append("'").append(elem.getKey()).append("'")
                            .append(" was updated. From ").append("'").append(dataMap1.get(elem.getKey()))
                            .append("'").append(" to ").append("'").append(dataMap2.get(elem.getKey())).append("'")
                            .append("\n");
                } else if (isStringValue(dataMap1.get(elem.getKey()))) {
                    result.append("Property ").append("'").append(elem.getKey()).append("'")
                            .append(" was updated. From ").append("'").append(dataMap1.get(elem.getKey()))
                            .append("'").append(" to ").append(dataMap2.get(elem.getKey())).append("\n");
                } else if (isStringValue(dataMap2.get(elem.getKey()))) {
                    result.append("Property ").append("'").append(elem.getKey()).append("'")
                            .append(" was updated. From ").append(dataMap1.get(elem.getKey())).append(" to ")
                            .append("'").append(dataMap2.get(elem.getKey())).append("'").append("\n");
                } else {
                    result.append("Property ").append("'").append(elem.getKey()).append("'")
                            .append(" was updated. From ").append(dataMap1.get(elem.getKey()))
                            .append(" to ").append(dataMap2.get(elem.getKey())).append("\n");
                }
            }
        }
        return result.toString();
    }

    private static boolean isComplexValue(Object elem) {
        return elem instanceof Map<?, ?> || elem instanceof List<?>;
    }

    private static boolean isStringValue(Object elem) {
        return elem instanceof String;
    }
}
