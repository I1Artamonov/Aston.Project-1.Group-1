package menu.showMenu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuCollectionsTest {

    @Test
    void menuShouldContainMainMenu() {
        assertTrue(MenuCollections.getMenuMap().containsKey("main"));
    }

    @Test
    void menuShouldContainSortMenu() {
        assertTrue(MenuCollections.getMenuMap().containsKey("sort"));
    }
}