package menu.menuAddBusCommands;

import menu.BusRepository;
import menu.userInputValidations.ManualAddValidation;
import parser.BusParser;

import java.util.Arrays;
import java.util.Scanner;

public class ManualAdd implements MenuBusAdding {
    int busCount;

    public ManualAdd(int busCount) {
        this.busCount = busCount;
    }

    @Override
    public void add() {

        String[] userInputBuses = new String[busCount];
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
                userInputBuses[i-1] = number + "," + model + "," + mileage;
                i++;
            }
        }

        Arrays.stream(userInputBuses)
                .map(str -> new BusParser().parse(str))
                .forEach(bus -> BusRepository.buses.add(bus));
    }
}
