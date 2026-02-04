package menu.userInputValidations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePathValidationTest {

    @Test
    void validTxtPath_shouldReturnTrue() {
        FilePathValidation validation = new FilePathValidation("data/buses.txt");
        assertTrue(validation.pathValidation());
    }

    @Test
    void invalidExtension_shouldReturnFalse() {
        FilePathValidation validation = new FilePathValidation("data/buses.csv");
        assertFalse(validation.pathValidation());
    }

    @Test
    void emptyPath_shouldReturnFalse() {
        FilePathValidation validation = new FilePathValidation("");
        assertFalse(validation.pathValidation());
    }
}