package menu.menuAddBusCommands;

import entity.Bus;
import menu.BusRepository;

public class RandomAdd implements MenuBusAdding {
    int busCount;

    public RandomAdd(int busCount) {
        this.busCount = busCount;
    }

    @Override
    public void add() {

        for (int i = 1; i <= busCount; i++) {
            BusRepository.buses.add(new Bus().generate());
        }
    }
}
