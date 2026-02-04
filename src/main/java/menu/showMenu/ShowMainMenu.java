package menu.showMenu;

public class ShowMainMenu implements ShowMenu{

    @Override
    public void show() {
        System.out.println("Выберите действие:\n" +
                "1 - добавление автобусов в базу\n" +
                "2 - вывести базу в консоль или файл\n" +
                "3 - отсортировать базу\n" +
                "4 - посчитать кол-во вхождений\n" +
                "0 - завершить работу программы");
    }
}