package userInputValidations;

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
        return number != null && !number.isEmpty();
    }

    public boolean modelValidate() {
        return model != null && !model.isEmpty();
    }

    public boolean mileageValidate() {
        return mileage != null
                && mileage.length() >0
                && mileage.matches("\\d+")
                && Integer.parseInt(mileage) >= 0;

    }


}
