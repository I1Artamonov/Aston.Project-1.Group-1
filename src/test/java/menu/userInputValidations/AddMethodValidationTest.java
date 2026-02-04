package menu.userInputValidations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddMethodValidationTest {

    @Test
    void validNumber_shouldReturnParsedInt() {
        AddMethodValidation validation = new AddMethodValidation("2");
        assertEquals(2, validation.addMethodValidation());
    }

    @Test
    void invalidNumber_shouldReturnMinusOne() {
        AddMethodValidation validation = new AddMethodValidation("abc");
        assertEquals(-1, validation.addMethodValidation());
    }
}