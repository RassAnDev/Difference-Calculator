package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    // getting the comparison result in the plain format
    public static String format(List<Map<String, Object>> listForFormatting) {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> elem : listForFormatting) {
            if (elem.containsValue("added")) {
                if (isComplexValue(elem.get("newValue"))) {
                    result.append("Property ").append("'").append(elem.get("key")).append("'")
                            .append(" was added with value: [complex value]").append("\n");
                } else if (isStringValue(elem.get("newValue"))) {
                    result.append("Property ").append("'").append(elem.get("key")).append("'")
                            .append(" was added with value: ").append("'").append(elem.get("newValue"))
                            .append("'").append("\n");
                } else {
                    result.append("Property ").append("'").append(elem.get("key")).append("'")
                            .append(" was added with value: ").append(elem.get("newValue")).append("\n");
                }
            } else if (elem.containsValue("deleted")) {
                result.append("Property ").append("'").append(elem.get("key")).append("'")
                        .append(" was removed").append("\n");
            } else if (elem.containsValue("changed")) {
                if (isComplexValue(elem.get("oldValue")) && isComplexValue(elem.get("newValue"))) {
                    result.append("Property ").append("'").append(elem.get("key")).append("'")
                            .append(" was updated. From [complex value] to [complex value]").append("\n");
                } else if (isComplexValue(elem.get("oldValue"))) {
                    result.append("Property ").append("'").append(elem.get("key")).append("'")
                            .append(" was updated. From [complex value] to ").append(elem.get("newValue"))
                            .append("\n");
                } else if (isComplexValue(elem.get("newValue"))) {
                    result.append("Property ").append("'").append(elem.get("key")).append("'")
                            .append(" was updated. From ").append(elem.get("oldValue"))
                            .append(" to [complex value]").append("\n");
                } else if (isStringValue(elem.get("oldValue"), elem.get("newValue"))) {
                    result.append("Property ").append("'").append(elem.get("key")).append("'")
                            .append(" was updated. From ").append("'").append(elem.get("oldValue"))
                            .append("'").append(" to ").append("'").append(elem.get("newValue")).append("'")
                            .append("\n");
                } else if (isStringValue(elem.get("oldValue"))) {
                    result.append("Property ").append("'").append(elem.get("key")).append("'")
                            .append(" was updated. From ").append("'").append(elem.get("oldValue"))
                            .append("'").append(" to ").append(elem.get("newValue")).append("\n");
                } else if (isStringValue(elem.get("newValue"))) {
                    result.append("Property ").append("'").append(elem.get("key")).append("'")
                            .append(" was updated. From ").append(elem.get("oldValue")).append(" to ")
                            .append("'").append(elem.get("newValue")).append("'").append("\n");
                } else {
                    result.append("Property ").append("'").append(elem.get("key")).append("'")
                            .append(" was updated. From ").append(elem.get("oldValue"))
                            .append(" to ").append(elem.get("newValue"));
                }
            }
        }
        return result.toString();
    }

    private static boolean isComplexValue(Object elem) {
        return elem instanceof Map<?, ?> || elem instanceof List<?>;
    }

    private static boolean isStringValue(Object elem1, Object elem2) {
        return elem1 instanceof String && elem2 instanceof String;
    }

    private static boolean isStringValue(Object elem) {
        String defaultElem = "";
        return isStringValue(elem, defaultElem);
    }
}
