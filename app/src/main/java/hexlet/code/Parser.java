package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String dataForParsing, String formatOfFile) throws IOException {
        switch (formatOfFile) {
            case "json":
                return parseJson(dataForParsing);
            case "yaml":
            case "yml":
                return parseYaml(dataForParsing);
            default:
                throw new IOException();
        }
    }

    public static Map<String, Object> parseJson(String dataForParsing) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(dataForParsing, new TypeReference<>() { });
    }

    public static Map<String, Object> parseYaml(String dataForParsing) throws IOException {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(dataForParsing, new TypeReference<>() { });
    }
}
