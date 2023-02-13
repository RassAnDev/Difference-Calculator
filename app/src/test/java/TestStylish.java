import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStylish {
    static String expected;
    static String actual;
    @BeforeAll
    public static void initData() throws Exception {
        Path directoryToResult = Paths.get("src/test/resources/result_stylish.txt").toAbsolutePath().normalize();
        expected = Files.readString(directoryToResult);
        actual = Differ.generate("filepath1.json", "filepath2.json");
    }

    @Test
    public void testCorrectResult() {
        assertEquals(expected, actual);
    }

}
