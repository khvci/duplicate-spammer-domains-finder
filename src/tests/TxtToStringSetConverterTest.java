package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tools.TxtToStringSetConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class TxtToStringSetConverterTest {

    @Test
    public void testConvertTxtToStringSet_ValidFile() throws IOException {
        // Given
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, "example.com example.org example.net");

        // When
        Set<String> result = TxtToStringSetConverter.convertTxtToStringSet(tempFile.toString());

        // Then
        Set<String> expected = new HashSet<>();
        expected.add("example.com");
        expected.add("example.org");
        expected.add("example.net");

        assertEquals(expected, result, "The result should contain all domains in the file.");

        // Cleanup
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testConvertTxtToStringSet_EmptyFile() throws IOException {
        // Given
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, ""); // Empty file

        // When
        Set<String> result = TxtToStringSetConverter.convertTxtToStringSet(tempFile.toString());

        // Then
        assertTrue(result.isEmpty(), "The result should be an empty set for an empty file.");

        // Cleanup
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testConvertTxtToStringSet_FileWithExtraWhitespace() throws IOException {
        // Given
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, "   example.com   example.org   example.net   ");

        // When
        Set<String> result = TxtToStringSetConverter.convertTxtToStringSet(tempFile.toString());

        // Then
        Set<String> expected = new HashSet<>();
        expected.add("example.com");
        expected.add("example.org");
        expected.add("example.net");

        assertEquals(expected, result, "Whitespace should be ignored and the result should contain all domains.");

        // Cleanup
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testConvertTxtToStringSet_NonExistentFile() {
        // Given
        String nonExistentFilePath = "nonexistent.txt";

        // When
        Set<String> result = TxtToStringSetConverter.convertTxtToStringSet(nonExistentFilePath);

        // Then
        assertTrue(result.isEmpty(), "The result should be an empty set when the file does not exist.");
    }

    @Test
    public void testConvertTxtToStringSet_FileWithNewlines() throws IOException {
        // Given
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, "example.com\nexample.org\nexample.net");

        // When
        Set<String> result = TxtToStringSetConverter.convertTxtToStringSet(tempFile.toString());

        // Then
        Set<String> expected = new HashSet<>();
        expected.add("example.com");
        expected.add("example.org");
        expected.add("example.net");

        assertEquals(expected, result, "Newlines should be correctly handled and the result should contain all domains.");

        // Cleanup
        Files.deleteIfExists(tempFile);
    }
}
