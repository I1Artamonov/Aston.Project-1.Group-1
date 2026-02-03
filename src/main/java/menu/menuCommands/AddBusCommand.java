package menu.menuCommands;

import menu.menuAddBusCommands.FromFileAdd;
import menu.menuAddBusCommands.ManualAdd;
import menu.menuAddBusCommands.MenuBusAdding;
import menu.menuAddBusCommands.RandomAdd;
import menu.showMenu.MenuCollections;
import menu.userInputValidations.AddMethodValidation;
import menu.userInputValidations.BusesCountValidation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddBusCommand implements Command {
    @Override
    public void execute() {

        int numberOfMethod = -1;
        int busesCount = -1;

        Map<Integer, MenuBusAdding> busAddingMethods = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (numberOfMethod < 0 && busesCount < 0) {

            System.out.println("Укажите количество добавляемых автобусов:");

            String count = scanner.nextLine();
            busesCount = new BusesCountValidation(count).busesCountValidation();

            if (busesCount <= 0) {
                System.out.println("Введите положительное число");
                continue;
            }

            busAddingMethods.put(1, new FromFileAdd(busesCount));
            busAddingMethods.put(2, new RandomAdd(busesCount));
            busAddingMethods.put(3, new ManualAdd(busesCount));

            while (!busAddingMethods.containsKey(numberOfMethod)) {

                System.out.println("Выберите способ добавления:");

                MenuCollections.getMenuMap().get("add").show();

                String userInput = scanner.nextLine();
                numberOfMethod = new AddMethodValidation(userInput).addMethodValidation();

                if (numberOfMethod == 0) {
                    return;
                } else if (numberOfMethod < 0 || !busAddingMethods.containsKey(numberOfMethod)) {
                    System.out.println("Ошибка ввода. Отсутствует указанный вариант добавления");
                }
            }
        }

        busAddingMethods.get(numberOfMethod).add();
    }
}