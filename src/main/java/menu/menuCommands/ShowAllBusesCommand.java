package menu.menuCommands;

import entity.Bus;
import menu.BusRepository;
import menu.showMenu.MenuCollections;
import menu.userInputValidations.FilePathValidation;
import writer.ResultWriter;
import writer.TextFileWriter;

import java.util.Scanner;

public class ShowAllBusesCommand implements Command {
    @Override
    public void execute() {

        boolean isRunning = true;
        String userInput;

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            MenuCollections.getMenuMap().get("result").show();

            userInput = scanner.nextLine().trim();

            if (userInput.equals("1")) {
                BusRepository.buses.forEach(System.out::println);
                break;
            } else if (userInput.equals("2")) {
                isRunning = writeToFile();
            } else {
                System.out.println("Указанного метода сортировки не существует. Укажите корректное значение");
            }
        }
    }

    private boolean writeToFile() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу. Файл должен быть в формате .txt");

        String userPath = scanner.nextLine().trim();

        if (new FilePathValidation(userPath).pathValidation()) {
            ResultWriter<Bus> writer = new TextFileWriter<>();
            writer.writeCollection(BusRepository.buses);
            return false;
        } else {
            System.out.println("Не корректный путь или формат файла. Попробуйте заново");
            return true;
        }
    }
}