package menuCommands;

import java.util.Scanner;

public class NumberOccurrencesCountingCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        System.out.println("Введите значение, которое хотите найти в базе и посчитать количество");

        String userInput = scanner.nextLine().trim();

        if (userInput != null && !userInput.isEmpty()) {
            //TODO
            //вызвать метод подсчета вхождений
            //присваиваем новое значение для count
        } else {
            System.out.println("Вы ввели не корректное значение");
        }

        if (count > 0) {
            System.out.println("Значение: " + userInput + "\nКоличество в базе " + count);
        } else {
            System.out.println("Значение: " + userInput + "\nв базе не найдено");
        }
    }
}
