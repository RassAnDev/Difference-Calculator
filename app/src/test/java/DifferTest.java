import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;
    private static String resultStylishYml;
    private static String resultPlainYml;
    private static String resultJsonYml;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }
    @BeforeAll
    public static void beforeAll() throws Exception {
        resultStylish = readFixture("result_stylish.txt");
        resultPlain = readFixture("result_plain.txt");
        resultJson = readFixture("result_json.txt");
        resultStylishYml = readFixture("result_stylish_yaml.txt");
        resultPlainYml = readFixture("result_plain_yaml.txt");
        resultJsonYml = readFixture("result_json_yaml.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json"})
    public void generateTestJson(String format) throws Exception {
        String filePath1 = getFixturePath("file1." + format).toString();
        String filePath2 = getFixturePath("file2." + format).toString();

        assertEquals(Differ.generate(filePath1, filePath2, "stylish"), resultStylish);
        assertEquals(Differ.generate(filePath1, filePath2, "plain"), resultPlain);
        assertEquals(Differ.generate(filePath1, filePath2, "json"), resultJson);
        assertEquals(Differ.generate(filePath1, filePath2), resultStylish);
    }

    @ParameterizedTest
    @ValueSource(strings = {"yaml"})
    public void generateTestYml(String format) throws Exception {
        String filePath1 = getFixturePath("file1." + format).toString();
        String filePath2 = getFixturePath("file2." + format).toString();

        assertEquals(Differ.generate(filePath1, filePath2, "stylish"), resultStylishYml);
        assertEquals(Differ.generate(filePath1, filePath2, "plain"), resultPlainYml);
        assertEquals(Differ.generate(filePath1, filePath2, "json"), resultJsonYml);
        assertEquals(Differ.generate(filePath1, filePath2), resultStylishYml);
    }
}
