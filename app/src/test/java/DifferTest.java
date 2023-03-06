import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    static String jsonFile1;
    static String jsonFile2;
    static String yamlFile1;
    static String yamlFile2;
    static String expected;
    static String actual;
    static Path pathToResult;
    @BeforeAll
    public static void initData() {
        Path pathToJsonFile1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path pathToJsonFile2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        Path pathToYamlFile1 = Paths.get("src/test/resources/file1.yaml").toAbsolutePath().normalize();
        Path pathToYamlFile2 = Paths.get("src/test/resources/file2.yaml").toAbsolutePath().normalize();
        jsonFile1 = pathToJsonFile1.toString();
        jsonFile2 = pathToJsonFile2.toString();
        yamlFile1 = pathToYamlFile1.toString();
        yamlFile2 = pathToYamlFile2.toString();
    }

    @Test
    public void testCorrectStylishResult() {
        pathToResult = Paths.get("src/test/resources/result_stylish.txt").toAbsolutePath().normalize();
        try {
            expected = Files.readString(pathToResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            actual = Differ.generate(jsonFile1, jsonFile2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectYamlResult() {
        pathToResult = Paths.get("src/test/resources/result_yaml.txt").toAbsolutePath().normalize();
        try {
            expected = Files.readString(pathToResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            actual = Differ.generate(yamlFile1, yamlFile2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectPlainResult() {
        pathToResult = Paths.get("src/test/resources/result_plain.txt").toAbsolutePath().normalize();
        try {
            expected = Files.readString(pathToResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            actual = Differ.generate(jsonFile1, jsonFile2, "plain");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectJsonResult() {
        pathToResult = Paths.get("src/test/resources/result_json.txt").toAbsolutePath().normalize();
        try {
            expected = Files.readString(pathToResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            actual = Differ.generate(jsonFile1, jsonFile2, "json");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, actual);
    }
}
