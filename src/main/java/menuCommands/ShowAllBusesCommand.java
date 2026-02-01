package menuCommands;

import static startProgramm.Main.getBuses;

public class ShowAllBusesCommand implements Command {
    @Override
    public void execute() {
        getBuses().forEach(System.out::println);
    }
}
