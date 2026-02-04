package reader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void testReadWithValidFile(@TempDir Path tempDir) throws IOException {
        // Arrange
        File testFile = tempDir.resolve("test.txt").toFile();
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("Line 1\n");
            writer.write("Line 2\n");
            writer.write("Line 3\n");
        }

        FileReader fileReader = new FileReader();

        // Act
        String[] result = fileReader.read(testFile.getAbsolutePath());

        // Assert
        assertEquals(3, result.length);
        assertEquals("Line 1", result[0]);
        assertEquals("Line 2", result[1]);
        assertEquals("Line 3", result[2]);
    }

    @Test
    void testReadWithEmptyFile(@TempDir Path tempDir) throws IOException {
        // Arrange
        File testFile = tempDir.resolve("empty.txt").toFile();
        testFile.createNewFile();

        FileReader fileReader = new FileReader();

        // Act
        String[] result = fileReader.read(testFile.getAbsolutePath());

        // Assert
        assertEquals(0, result.length);
    }

    @Test
    void testReadWithNonExistentFile() {
        // Arrange
        FileReader fileReader = new FileReader();

        // Act
        String[] result = fileReader.read("non_existent_file.txt");

        // Assert
        assertEquals(0, result.length);
    }

    @Test
    void testReadWithNullPath() {
        // Arrange
        FileReader fileReader = new FileReader();

        // Act
        String[] result = fileReader.read(null);

        // Assert
        assertEquals(0, result.length);
    }

    @Test
    void testReadWithSingleLineFile(@TempDir Path tempDir) throws IOException {
        // Arrange
        File testFile = tempDir.resolve("single.txt").toFile();
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("Single line content");
        }

        FileReader fileReader = new FileReader();

        // Act
        String[] result = fileReader.read(testFile.getAbsolutePath());

        // Assert
        assertEquals(1, result.length);
        assertEquals("Single line content", result[0]);
    }

    @Test
    void testReadWithFileContainingEmptyLines(@TempDir Path tempDir) throws IOException {
        // Arrange
        File testFile = tempDir.resolve("empty_lines.txt").toFile();
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("First line\n");
            writer.write("\n"); // empty line
            writer.write("Third line\n");
        }

        FileReader fileReader = new FileReader();

        // Act
        String[] result = fileReader.read(testFile.getAbsolutePath());

        // Assert
        assertEquals(3, result.length);
        assertEquals("First line", result[0]);
        assertEquals("", result[1]); // empty string for empty line
        assertEquals("Third line", result[2]);
    }
}
