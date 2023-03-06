package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonFormatter {
    public static String format(List<Map<String, Object>> listForFormatting) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> elem : listForFormatting) {
            result.append(mapper.writeValueAsString(elem)).append(",\n");
        }
        return result.deleteCharAt(result.length() - 2).toString();
    }
}
