package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;


public class Differ {
    public static String generate(String inputPath1, String inputPath2, String formatName) throws Exception {
        Path filePath1 = getAbsolutePath(inputPath1);
        Path filePath2 = getAbsolutePath(inputPath2);

        String dataFromFile1 = getDataFromFile(filePath1);
        String dataFromFile2 = getDataFromFile(filePath2);

        String formatOfFile1 = getFormat(inputPath1);
        String formatOfFile2 = getFormat(inputPath2);

        Map<String, Object> dataMap1 = new TreeMap<>();
        Map<String, Object> dataMap2 = new TreeMap<>();
        List<Map<String, Object>> resultOfComparing;

        if (formatOfFile1.equals("json") && formatOfFile2.equals("json")) {
            dataMap1 = Parser.parseJson(dataFromFile1);
            dataMap2 = Parser.parseJson(dataFromFile2);
        } else if (formatOfFile1.equals("yaml") && formatOfFile2.equals("yaml")) {
            dataMap1 = Parser.parseYaml(dataFromFile1);
            dataMap2 = Parser.parseYaml(dataFromFile2);
        }

        if (formatOfFile1.equals(formatOfFile2)) {
            resultOfComparing = compareData(dataMap1, dataMap2);
        } else {
            throw new IllegalArgumentException();
        }

        return Formatter.format(resultOfComparing, formatName);
    }

    public static String generate(String inputPath1, String inputPath2) throws Exception {
        String defaultFormat = "stylish";
        return generate(inputPath1, inputPath2, defaultFormat);
    }

    // getting an absolute path to file from a given input path
    private static Path getAbsolutePath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    // reading data from files which were given
    private static String getDataFromFile(Path file) throws IOException {
        return Files.readString(file);
    }

    // getting the formats of provided files
    private static String getFormat(String format) {
        String resultFormat = "";

        if (format.endsWith(".json")) {
            resultFormat = "json";
        } else if (format.endsWith(".yaml") || format.endsWith(".yml")) {
            resultFormat = "yaml";
        }
        return resultFormat;
    }

    // comparing two files and finding differences
    private static List<Map<String, Object>> compareData(Map<String, Object> dataMap1, Map<String, Object> dataMap2) {
        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> keys = new TreeSet<>(dataMap1.keySet());
        keys.addAll(dataMap2.keySet());

        for (String key : keys) {
            Map<String, Object> resultMap = new TreeMap<>();
            if (!dataMap1.containsKey(key)) {
                resultMap.put("key", key);
                resultMap.put("status", "added");
                resultMap.put("newValue", dataMap2.get(key));
                result.add(resultMap);
            } else if (!dataMap2.containsKey(key)) {
                resultMap.put("key", key);
                resultMap.put("status", "deleted");
                resultMap.put("oldValue", dataMap1.get(key));
                result.add(resultMap);
            } else if (!(Objects.equals(dataMap2.get(key), dataMap1.get(key)))) {
                resultMap.put("key", key);
                resultMap.put("status", "changed");
                resultMap.put("oldValue", dataMap1.get(key));
                resultMap.put("newValue", dataMap2.get(key));
                result.add(resultMap);
            } else {
                resultMap.put("key", key);
                resultMap.put("status", "unchanged");
                resultMap.put("newValue", dataMap2.get(key));
                result.add(resultMap);
            }
        }
        return result;
    }
}
