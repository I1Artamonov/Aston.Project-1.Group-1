package menu.showMenu;

public class ShowSortingMenu implements ShowMenu{

    @Override
    public void show() {
        System.out.println("Укажите параметр для сортировки:\n" +
                "1 - номер\n" +
                "2 - модель\n" +
                "3 - пробег\n" +
                "4 - перемещение четных в натуральном порядке\n" +
                "0 - вернуться в главное меню");
    }
}