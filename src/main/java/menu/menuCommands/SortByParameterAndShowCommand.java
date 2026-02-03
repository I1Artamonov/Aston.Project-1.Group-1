package menu.menuCommands;

import menu.BusRepository;
import menu.showMenu.MenuCollections;
import sorting.Sorting;

import java.util.Scanner;

public class SortByParameterAndShowCommand implements Command {
    @Override
    public void execute() {

        boolean isRunning = true;

        String userInput;
        Sorting sorting = new Sorting();

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            MenuCollections.getMenuMap().get("sort").show();

            userInput = scanner.nextLine().trim();
            //TODO: раскомментировать после слияния 2 строки. Пока вижу только старую реализацию методов с List
            if (userInput.startsWith("1")) {
                //BusRepository.buses = sorting.selectionSort(BusRepository.buses, sorting.selectComparator(1));
            } else if (userInput.startsWith("2")) {
                //BusRepository.buses = sorting.selectionSort(BusRepository.buses, sorting.selectComparator(2));
            } else if (userInput.startsWith("3")) {
                //BusRepository.buses = sorting.selectionSort(BusRepository.buses, sorting.selectComparator(3));
            } else if (userInput.startsWith("4")) {
                //BusRepository.buses = sorting.sortEvenKeepOdd(BusRepository.buses);
            } else if (userInput.startsWith("0")) {
                break;
            } else {
                System.out.println("Указанного метода сортировки не существует");
            }
        }
    }
}
