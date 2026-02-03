package menu.menuAddBusCommands;

import menu.BusRepository;
import menu.userInputValidations.FilePathValidation;
import parser.BusParser;
import reader.FileReader;

import java.util.Arrays;
import java.util.Scanner;

public class FromFileAdd implements MenuBusAdding {
    int busCount;

    public FromFileAdd(int busCount) {
        this.busCount = busCount;
    }

    @Override
    public void add() {

        System.out.println("Введите путь к файлу. Файл должен быть в формате .txt\n" +
                "!!!Обратите внимание!!!\n" +
                "Каждая строка в файле должна содержать данные 1 автобуса.\n" +
                "Данные должны идти в следующем порядке и разделяться запятой:\n" +
                "номер (целое число), модель, пробег (целое число)");

        Scanner scanner = new Scanner(System.in);
        String userPath = scanner.nextLine().trim();

        boolean isRunningLoop = true;

        while (isRunningLoop) {
            if (new FilePathValidation(userPath).pathValidation()) {
                isRunningLoop = false;
            } else {
                System.out.println("Не корректный путь или формат файла. Попробуйте заново");
            }
        }

        FileReader fileReader = new FileReader();
        String[] busesFromUserFile = Arrays.stream(fileReader.read(userPath))
                .limit(busCount)
                .toArray(String[]::new);

        Arrays.stream(busesFromUserFile)
                .map(str -> new BusParser().parse(str))
                .forEach(bus -> BusRepository.buses.add(bus));
    }
}
