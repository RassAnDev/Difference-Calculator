package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    // getting the comparison result in the plain format
    public static String format(List<Map<String, Object>> listForFormatting) {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> elem : listForFormatting) {
            String status = elem.get("status").toString();
            String formattedNewValue = stringify(elem.get("newValue"));
            String formattedOldValue = stringify(elem.get("oldValue"));

            switch (status) {
                case "added":
                    result.append(getProperty(elem)).append("was added").append(" with value: ")
                            .append(formattedNewValue).append("\n");
                    break;
                case "deleted":
                    result.append(getProperty(elem)).append("was removed").append("\n");
                    break;
                case "changed":
                    result.append(getProperty(elem)).append("was updated.").append(" From ")
                            .append(formattedOldValue).append(" to ").append(formattedNewValue).append("\n");
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException("Unknown status of element: '" + status + "'");
            }
        }
        return result.toString().trim();
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

    private static String getProperty(Map<String, Object> elem) {
        return "Property '" + elem.get("key") + "' ";
    }

    private static String stringify(Object value) {
        if (isComplexValue(value)) {
            return "[complex value]";
        } else if (isStringValue(value)) {
            return "'" + value.toString() + "'";
        } else if (value == null) {
            return "null";
        }
        return value.toString();
    }
}
