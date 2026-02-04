package menu.menuCommands;

import entity.Bus;
import menu.BusRepository;
import menu.userInputValidations.IsExistsString;
import menu.userInputValidations.IsNumberValidation;

import java.util.Scanner;

public class NumberOccurrencesCountingCommand implements Command {
    @Override
    public void execute() {
        int number;
        String model;
        int mileage;

        Scanner scanner = new Scanner(System.in);
        String userInput;
        IsNumberValidation isNumberValidation = new IsNumberValidation();

        System.out.println("Введите данные автобуса, который хотите найти в базе и посчитать количество");

        while (true) {
            System.out.println("Введите номер автобуса (целое число)");
            userInput = scanner.nextLine().trim();

            if (isNumberValidation.isNumber(userInput) > 0) {
                number = Integer.parseInt(userInput);
                break;
            } else {
                System.out.println("Укажите корректное значение");
            }
        }

        while (true) {
            System.out.println("Введите модель");
            userInput = scanner.nextLine().trim();

            if (new IsExistsString().isExists(userInput)) {
                model = userInput;
                break;
            } else {
                System.out.println("Укажите корректное значение");
            }
        }

        while (true) {
            System.out.println("Введите пробег (целое число)");
            userInput = scanner.nextLine().trim();

            if (isNumberValidation.isNumber(userInput) >= 0) {
                mileage = Integer.parseInt(userInput);
                break;
            } else {
                System.out.println("Укажите корректное значение");
            }
        }

        Bus bus = new Bus.BusBuilder().setMileage(mileage).setModel(model).setNumber(number).build();
        BusRepository.buses.countOccurrencesParallel(bus);
    }
}