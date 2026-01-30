package userInputValidations;

public class AddMethodValidation {
    private String userInput;

    public AddMethodValidation(String userInput) {
        this.userInput = userInput;
    }

    public int addMethodValidation() {
        int NumberOfMethod = -1;
        try {
            NumberOfMethod = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Введите число еще раз");
        }
        return NumberOfMethod;
    }
}
