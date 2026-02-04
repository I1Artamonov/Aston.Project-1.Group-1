package menu.menuAddBusCommands;

import customCollections.CustomList;
import menu.BusRepository;
import menu.menuAddBusCommands.RandomAdd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomAddTest {

    @BeforeEach
    void resetRepository() {
        BusRepository.buses = new CustomList<>();
    }

    @Test
    void add_shouldAddExactNumberOfBuses() {
        RandomAdd randomAdd = new RandomAdd(5);

        randomAdd.add();

        assertEquals(5, BusRepository.buses.size());
    }
}