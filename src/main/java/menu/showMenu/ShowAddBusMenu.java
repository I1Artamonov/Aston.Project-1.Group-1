package menu.showMenu;

public class ShowAddBusMenu implements ShowMenu{
    @Override
    public void show() {
        System.out.println("Укажите способ добавления:\n" +
                "1 - из файла\n" +
                "2 - рандом\n" +
                "3 - вручную\n" +
                "0 - вернуться в главное меню");
    }
}