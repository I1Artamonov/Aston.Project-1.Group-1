package menu.userInputValidations;

public class ManualAddValidation {
    private String number;
    private String model;
    private String mileage;

    public ManualAddValidation(String number, String model, String mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public boolean numberValidate() {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean modelValidate() {
        return model != null && !model.isEmpty();
    }

    public boolean mileageValidate() {
        return mileage != null
                && mileage.length() >0
                && mileage.matches("\\d+")
                && new IsNumberValidation().isNumber(mileage) >= 0;
    }
}