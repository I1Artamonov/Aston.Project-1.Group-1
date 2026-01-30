package userInputValidations;

public class BusesCountValidation {
    private String count;

    public BusesCountValidation(String count) {
        this.count = count;
    }

    public int busesCountValidation() {
        int busesCount = -1;

        try {
            busesCount = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Введите число еще раз");
        }
        return busesCount;
    }
}
