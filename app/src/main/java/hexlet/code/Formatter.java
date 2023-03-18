package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> listForFormatting, String requiredFormat) throws Exception {
        switch (requiredFormat) {
            case "stylish":
                return StylishFormatter.format(listForFormatting);
            case "plain":
                return PlainFormatter.format(listForFormatting);
            case "json":
                return JsonFormatter.format(listForFormatting);
            default:
                throw new Exception("This format is not supported: " + requiredFormat);
        }
    }
}
