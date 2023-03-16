package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    // getting the comparison result in the stylish format
    public static String format(List<Map<String, Object>> listForFormatting) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> elem : listForFormatting) {
            String status = elem.get("status").toString();

            switch (status) {
                case "added":
                    result.append(" ".repeat(2)).append("+ ").append(elem.get("key")).append(": ")
                            .append(elem.get("newValue")).append("\n");
                    break;
                case "deleted":
                    result.append(" ".repeat(2)).append("- ").append(elem.get("key")).append(": ")
                            .append(elem.get("oldValue")).append("\n");
                    break;
                case "changed":
                    result.append(" ".repeat(2)).append("- ").append(elem.get("key")).append(": ")
                            .append(elem.get("oldValue")).append("\n")
                            .append("  + ").append(elem.get("key")).append(": ")
                            .append(elem.get("newValue")).append("\n");
                    break;
                case "unchanged":
                    result.append(" ".repeat(4)).append(elem.get("key")).append(": ")
                            .append(elem.get("newValue")).append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown status of element: '" + status + "'");
            }
        }
        result.append("}");
        return result.toString();
    }
}
