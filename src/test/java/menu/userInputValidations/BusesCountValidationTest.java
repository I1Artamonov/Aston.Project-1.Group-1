package menu.userInputValidations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusesCountValidationTest {

    @Test
    void validCount_shouldReturnNumber() {
        BusesCountValidation validation = new BusesCountValidation("5");
        assertEquals(5, validation.busesCountValidation());
    }

    @Test
    void invalidCount_shouldReturnMinusOne() {
        BusesCountValidation validation = new BusesCountValidation("qwe");
        assertEquals(-1, validation.busesCountValidation());
    }
}