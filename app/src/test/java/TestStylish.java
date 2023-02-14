import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStylish {
    static String file1;
    static String file2;
    static String expected;
    static String actual;
    @BeforeAll
    public static void initData() throws Exception {
        Path directoryToFile1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path directoryToFile2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        Path directoryToResult = Paths.get("src/test/resources/result_stylish.txt").toAbsolutePath().normalize();
        file1 = directoryToFile1.toString();
        file2 = directoryToFile2.toString();
        expected = Files.readString(directoryToResult);
        actual = Differ.generate(file1, file2);
    }

    @Test
    public void testCorrectResult() {
        assertEquals(expected, actual);
    }

}
