package menuCommands;


import menuAddBusMethods.FromFileAdd;
import menuAddBusMethods.ManualAdd;
import menuAddBusMethods.MenuBusAdding;
import menuAddBusMethods.RandomAdd;
import startProgramm.Main;
import userInputValidations.BusesCountValidation;
import userInputValidations.AddMethodValidation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddBusCommand implements Command {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        int busesCount = -1;
        int numberOfMethod = -1;

        System.out.println("Укажите кол-во автобусов, которое вы хотите добавить в базу\n" +
                "0 - для возврата в меню");

        while (busesCount < 0) {
            String count = scanner.nextLine();
            busesCount = new BusesCountValidation(count).busesCountValidation();

            if (busesCount == 0) {
                break;
            }
            if (busesCount < 0) {
                System.out.println("Введите положительное число");
            }
        }

        addMenuShow();

        while (numberOfMethod < 0) {
            String userInput = scanner.nextLine();
            numberOfMethod = new AddMethodValidation(userInput).addMethodValidation();

            if (numberOfMethod == 0) {
                break;
            }
            if (numberOfMethod < 0) {
                System.out.println("Введите положительное число");
            }
        }

        Map<Integer, MenuBusAdding> busAddingMethods = new HashMap<>();
        busAddingMethods.put(1, new FromFileAdd(busesCount));
        busAddingMethods.put(2, new RandomAdd(busesCount));
        busAddingMethods.put(3, new ManualAdd(busesCount));

        if (busAddingMethods.containsKey(numberOfMethod)) {
            Main.setBuses(busAddingMethods.get(numberOfMethod).add());
        }
    }

    private void addMenuShow() {
        System.out.println("Укажите способ добавления:\n" +
                "1 - из файла\n" +
                "2 - рандом\n" +
                "3 - вручную\n" +
                "0 - завершить работу программы");
    }
}
