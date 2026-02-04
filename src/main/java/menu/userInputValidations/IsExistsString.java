package menu.userInputValidations;

public class IsExistsString {

    public boolean isExists(String userInput) {
        return userInput != null && !userInput.isEmpty();
    }
}