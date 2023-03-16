package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonFormatter {
    public static String format(List<Map<String, Object>> listForFormatting) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(listForFormatting);
    }
}
