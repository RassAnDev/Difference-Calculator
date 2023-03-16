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
    static Path stylishResult;
    static Path plainResult;
    static Path jsonResult;
    static Path stylishYmlResult;
    static Path plainYmlResult;
    static Path jsonYmlResult;

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
        stylishResult = Paths.get("src/test/resources/result_stylish.txt").toAbsolutePath().normalize();
        plainResult = Paths.get("src/test/resources/result_plain.txt").toAbsolutePath().normalize();
        jsonResult = Paths.get("src/test/resources/result_json.txt").toAbsolutePath().normalize();
        stylishYmlResult = Paths.get("src/test/resources/result_stylish_yaml.txt").toAbsolutePath().normalize();
        plainYmlResult = Paths.get("src/test/resources/result_plain_yaml.txt").toAbsolutePath().normalize();
        jsonYmlResult = Paths.get("src/test/resources/result_json_yaml.txt").toAbsolutePath().normalize();
    }

    @Test
    public void testJsonToStylishFormat() {
        try {
            expected = Files.readString(stylishResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            actual = Differ.generate(jsonFile1, jsonFile2, "stylish");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonToPlainFormat() {
        try {
            expected = Files.readString(plainResult);
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
    public void testJsonToJsonFormat() {
        try {
            expected = Files.readString(jsonResult);
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

    @Test
    public void testJsonToDefaultFormat() {
        try {
            expected = Files.readString(stylishResult);
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
    public void testYmlToStylishFormat() {
        try {
            expected = Files.readString(stylishYmlResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            actual = Differ.generate(yamlFile1, yamlFile2, "stylish");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testYmlToPlainFormat() {
        try {
            expected = Files.readString(plainYmlResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            actual = Differ.generate(yamlFile1, yamlFile2, "plain");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testYmlToJsonFormat() {
        try {
            expected = Files.readString(jsonYmlResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            actual = Differ.generate(yamlFile1, yamlFile2, "json");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testYmlToDefaultFormat() {
        try {
            expected = Files.readString(stylishYmlResult);
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
}
