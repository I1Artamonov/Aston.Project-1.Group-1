package startProgramm;

import bus.Bus;
import menuCommands.*;

import java.util.*;

public class Main {

    private static List<Bus> buses = new ArrayList<>();

    public static void main(String[] args) {

        ShowMenu showMenu = new ShowMenu();

        System.out.println("Здравствуй, дорогой друг!" +
                "\nТебя приветствует база данных нашего автобусного парка." +
                "\nЗагружаем меню..." +
                "\n");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        startProgram(showMenu);
    }

    private static void startProgram(ShowMenu showMenu) {
        boolean isRunning = true;

        Map<String, Command> menuCommands = new HashMap<>();
        menuCommands.put("1", new AddBusCommand());
        menuCommands.put("2", new SearchBusCommand());
        menuCommands.put("3", new ShowAllBusesCommand());
        menuCommands.put("4", new SortByParameterAndShowCommand());
        menuCommands.put("5", new NumberOccurrencesCountingCommand());
        menuCommands.put("0", new ExitCommand());

        Scanner scanner = new Scanner(System.in);

        while(isRunning) {

            showMenu.show();
            String userInput = scanner.nextLine();

            if (menuCommands.containsKey(userInput)) {
                menuCommands.get(userInput).execute();
            } else {
                System.out.println("Вы указали отсутствующий пункт меню.\n" +
                        "Сделайте выбор заново.\n");
            }
        }
    }

    public static void setBuses(List<Bus> buses) {
        if (buses != null && !buses.isEmpty()) {
            Main.buses = buses;
        }
    }

    public static List<Bus> getBuses() {
        return buses;
    }
}