package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, String> dataForFormat, Map<String, Object> dataMap1,
                                Map<String, Object> dataMap2,  String requiredFormat) {
        if (requiredFormat.equals("stylish")) {
            return StylishFormatter.format(dataForFormat, dataMap1, dataMap2);
        } else if (requiredFormat.equals("plain")) {
            return PlainFormatter.format(dataForFormat,dataMap1, dataMap2);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
