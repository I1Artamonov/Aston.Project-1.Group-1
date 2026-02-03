package menu.userInputValidations;

public class AddMethodValidation {
    private String userInput;

    public AddMethodValidation(String userInput) {
        this.userInput = userInput;
    }

    public int addMethodValidation() {
        int numberOfMethod = -1;
        try {
            numberOfMethod = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Введите число еще раз");
        }
        return numberOfMethod;
    }
}