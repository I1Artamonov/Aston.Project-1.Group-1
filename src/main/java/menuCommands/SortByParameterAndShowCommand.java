package menuCommands;

import java.util.Scanner;

public class SortByParameterAndShowCommand implements Command {
    @Override
    public void execute() {
        int fieldNumber;
        String userInput;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите поле для сортировки базы" +
                "\n 1 - для сортировки по номеру" +
                "\n 2 - для сортировки по модели" +
                "\n 3 - для сортировки по пробегу");
        userInput = scanner.nextLine().trim();

        //TODO
        if (userInput.startsWith("1")) {
            //вызвать сортировку и передать 1
        } else if (userInput.startsWith("2")) {
            //вызвать сортировку и передать 2
        } else if (userInput.startsWith("3")) {
            //вызвать сортировку и передать 3
        } else {
            System.out.println("Указанного метода сортировки не существует");
        }
    }
}
