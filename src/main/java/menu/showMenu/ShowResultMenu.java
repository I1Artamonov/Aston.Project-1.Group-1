package menu.showMenu;

public class ShowResultMenu implements ShowMenu{

    @Override
    public void show() {
        System.out.println("Способ выдачи результата:\n" +
                "1 - в консоль\n" +
                "2 - в файл\n");
    }
}