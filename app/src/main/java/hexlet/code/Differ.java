package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class Differ {
    public static String generate(String inputPath1, String inputPath2, String formatName) throws Exception {
        Path filePath1 = getAbsolutePath(inputPath1);
        Path filePath2 = getAbsolutePath(inputPath2);

        String dataFromFile1 = getDataFromFile(filePath1);
        String dataFromFile2 = getDataFromFile(filePath2);

        String formatOfFile1 = getFormat(filePath1);
        String formatOfFile2 = getFormat(filePath2);

        Map<String, Object> dataMap1;
        Map<String, Object> dataMap2;
        List<Map<String, Object>> resultOfComparing;

        if (formatOfFile1.equals(formatOfFile2)) {
            dataMap1 = Parser.parse(dataFromFile1, formatOfFile1);
            dataMap2 = Parser.parse(dataFromFile2, formatOfFile2);
            resultOfComparing = Comparator.compare(dataMap1, dataMap2);
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
    private static String getFormat(Path pathToFile) {
        String fileName = pathToFile.getFileName().toString();
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
