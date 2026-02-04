package menu.userInputValidations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManualAddValidationTest {

    @Test
    void validData_shouldReturnTrue() {
        ManualAddValidation validation =
                new ManualAddValidation("10", "Volvo", "100000");

        assertTrue(validation.numberValidate());
        assertTrue(validation.modelValidate());
        assertTrue(validation.mileageValidate());
    }

    @Test
    void invalidMileage_shouldReturnFalse() {
        ManualAddValidation validation =
                new ManualAddValidation("10", "Volvo", "-5");

        assertFalse(validation.mileageValidate());
    }
}