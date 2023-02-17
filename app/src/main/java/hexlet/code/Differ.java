package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.zip.DataFormatException;


public class Differ {
    public static String generate(String inputPath1, String inputPath2, String formatName) throws Exception {
        Path filePath1 = getAbsolutePath(inputPath1);
        Path filePath2 = getAbsolutePath(inputPath2);

        String dataFromFile1 = getDataFromFile(filePath1);
        String dataFromFile2 = getDataFromFile(filePath2);

        String formatOfFile1 = getFormat(inputPath1);
        String formatOfFile2 = getFormat(inputPath2);

        Map<String, Object> dataMap1 = null;
        Map<String, Object> dataMap2 = null;
        Map<String, String> resultMap;

        if (formatOfFile1.equals("json") && formatOfFile2.equals("json")) {
            dataMap1 = Parser.parseJson(dataFromFile1);
            dataMap2 = Parser.parseJson(dataFromFile2);
        } else if (formatOfFile1.equals("yaml") && formatOfFile2.equals("yaml")) {
            dataMap1 = Parser.parseYaml(dataFromFile1);
            dataMap2 = Parser.parseYaml(dataFromFile2);
        }

        if (dataMap1 == null && dataMap2 == null) {
            throw new NullPointerException();
        }

        if (formatOfFile1.equals(formatOfFile2)) {
            resultMap = compareData(dataMap1, dataMap2);
        } else {
            throw new DataFormatException();
        }

        return getResultOutputFormat(resultMap, dataMap1, dataMap2);
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
    private static Map<String, String> compareData(Map<String, Object> dataMap1, Map<String, Object> dataMap2) {
        Map<String, String> resultMap = new TreeMap<>();

        Set<String> keys = new TreeSet<>(dataMap1.keySet());
        keys.addAll(dataMap2.keySet());

        for (String key : keys) {
            if (!dataMap1.containsKey(key)) {
                resultMap.put(key, "added");
            } else if (!dataMap2.containsKey(key)) {
                resultMap.put(key, "deleted");
            } else if (!(dataMap2.get(key).equals(dataMap1.get(key)))) {
                resultMap.put(key, "changed");
            } else {
                resultMap.put(key, "unchanged");
            }
        }
        return resultMap;
    }

    // getting the comparison result in the required format
    private static String getResultOutputFormat(Map<String, String> dataForFormat, Map<String, Object> dataMap1,
                                                 Map<String, Object> dataMap2) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map.Entry<String, String> elem : dataForFormat.entrySet()) {
            if (elem.getValue().equals("added")) {
                result.append(" + ").append(elem.getKey()).append(": ")
                        .append(dataMap2.get(elem.getKey())).append("\n");
            } else if (elem.getValue().equals("deleted")) {
                result.append(" - ").append(elem.getKey()).append(": ")
                        .append(dataMap1.get(elem.getKey())).append("\n");
            } else if (elem.getValue().equals("changed")) {
                result.append(" - ").append(elem.getKey()).append(": ")
                        .append(dataMap1.get(elem.getKey())).append("\n")
                        .append(" + ").append(elem.getKey()).append(": ")
                        .append(dataMap2.get(elem.getKey())).append("\n");
            } else {
                result.append("   ").append(elem.getKey()).append(": ")
                        .append(dataMap2.get(elem.getKey())).append("\n");
            }
        }
        result.append("}\n");
        return result.toString();
    }
}
