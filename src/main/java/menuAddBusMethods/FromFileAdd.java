package menuAddBusMethods;

import bus.Bus;
import userInputValidations.FromFileAddValidation;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FromFileAdd implements MenuBusAdding<Bus> {
    int busCount;
    List<Bus> buses = null;

    public FromFileAdd(int busCount) {
        this.busCount = busCount;
    }

    @Override
    public List<Bus> add() {

        System.out.println("Введите путь к файлу. Файл должен быть в одном из форматов: .txt, .doc, .docx, .pdf");

        Scanner scanner = new Scanner(System.in);
        String userPath = scanner.nextLine().trim();

        boolean isRunningLoop = true;

        while (isRunningLoop) {
            if (new FromFileAddValidation(userPath).pathValidation()) {
                Path path = Path.of(userPath);
                //buses = передать путь для чтения и парсинга
                isRunningLoop = false;
            } else {
                System.out.println("Не корректный путь. Попробуйте заново");
            }
        }

        return buses;
    }
}
