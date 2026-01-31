package menuAddBusMethods;

import bus.Bus;
import userInputValidations.ManualAddValidation;

import java.util.List;
import java.util.Scanner;

public class ManualAdd implements MenuBusAdding<Bus>{
    int busCount;

    public ManualAdd(int busCount) {
        this.busCount = busCount;
    }

    @Override
    public List<Bus> add() {

        String[][] userInputBuses = new String[busCount][3];
        String number;
        String model;
        String mileage;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные автобусов");

        int i = 1;
        while (i <= busCount){
            System.out.println("Введите данные автобуса с порядковым номером: " + i);

            System.out.println("Введите номер");
            number = scanner.nextLine().trim();

            System.out.println("Введите модель");
            model = scanner.nextLine().trim();

            System.out.println("Введите пробег автобуса (целое число >= 0)");
            mileage = scanner.nextLine().trim();

            ManualAddValidation manualAddValidation = new ManualAddValidation(number, model, mileage);

            if (!manualAddValidation.numberValidate()
                    || !manualAddValidation.modelValidate()
                    || !manualAddValidation.mileageValidate()) {
                System.out.println("Вы ввели не корректные значения. Попробуйте заново");
            } else {
                userInputBuses[i-1][0] = number;
                userInputBuses[i-1][1] = model;
                userInputBuses[i-1][2] = mileage;
                i++;
            }

        }

        //вызвать метод, который примет массив и отдаст коллекцию автобусов

        return List.of();
    }
}
