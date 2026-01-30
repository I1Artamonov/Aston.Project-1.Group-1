package menuCommands;

import bus.Bus;
import userInputValidations.BusesCountValidation;
import userInputValidations.AddMethodValidation;

import java.util.ArrayList;
import java.util.List;
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

            if (busesCount == 0) {
                break;
            }

            if (busesCount < 0) {
                System.out.println("Введите положительное число");
            }
        }

        switch (numberOfMethod) {
            case 1, 2 -> System.out.println("метод в разработке");
            case 3 -> manualAdd(busesCount);
        }
    }

    private void addMenuShow() {
        System.out.println("Укажите способ добавления:\n" +
                "1 - из файла\n" +
                "2 - рандом\n" +
                "3 - вручную\n" +
                "0 - завершить работу программы");
    }

    private void manualAdd(int count) {
        String[] busArray = new String[count];
        //здесь сформированную коллекцию предать в мейн
    }
}
