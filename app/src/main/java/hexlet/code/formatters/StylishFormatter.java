package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    // getting the comparison result in the stylish format
    public static String format(List<Map<String, Object>> listForFormatting) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> elem : listForFormatting) {
            if (elem.containsValue("added")) {
                result.append("  + ").append(elem.get("key")).append(": ")
                        .append(elem.get("newValue")).append("\n");
            } else if (elem.containsValue("deleted")) {
                result.append("  - ").append(elem.get("key")).append(": ")
                        .append(elem.get("oldValue")).append("\n");
            } else if (elem.containsValue("changed")) {
                result.append("  - ").append(elem.get("key")).append(": ")
                        .append(elem.get("oldValue")).append("\n")
                        .append("  + ").append(elem.get("key")).append(": ")
                        .append(elem.get("newValue")).append("\n");
            } else {
                result.append(" ".repeat(4)).append(elem.get("key")).append(": ")
                        .append(elem.get("newValue")).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
