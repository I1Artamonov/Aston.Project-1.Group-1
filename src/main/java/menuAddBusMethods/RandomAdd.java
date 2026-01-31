package menuAddBusMethods;

import bus.Bus;

import java.util.List;

public class RandomAdd implements MenuBusAdding<Bus> {
    int busCount;

    public RandomAdd(int busCount) {
        this.busCount = busCount;
    }

    @Override
    public List<Bus> add() {

        return List.of(); //вызвать рандомайзер и получить коллекцию
    }
}
