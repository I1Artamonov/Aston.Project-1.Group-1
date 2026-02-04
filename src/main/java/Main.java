import menu.menuCommands.*;
import menu.showMenu.MenuCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("""
                Здравствуй, дорогой друг!
                Тебя приветствует база данных нашего автобусного парка.
                Загружаем меню...
                """);

        startProgram();
    }

    private static void startProgram() {

        Map<String, Command> menuCommands = new HashMap<>();
        menuCommands.put("1", new AddBusCommand());
        menuCommands.put("2", new ShowAllBusesCommand());
        menuCommands.put("3", new SortByParameterAndShowCommand());
        menuCommands.put("4", new NumberOccurrencesCountingCommand());
        menuCommands.put("0", new ExitCommand());

        Scanner scanner = new Scanner(System.in);

        while(true) {

            MenuCollections.getMenuMap().get("main").show();

            String userInput = scanner.nextLine();

            if (menuCommands.containsKey(userInput)) {
                menuCommands.get(userInput).execute();
            } else {
                System.out.println("""
                        Вы указали отсутствующий пункт меню.
                        Сделайте выбор заново.
                        """);
            }
        }
    }
}