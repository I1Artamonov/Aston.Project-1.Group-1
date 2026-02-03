package menu.userInputValidations;

public class IsNumberValidation {

    public int isNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}