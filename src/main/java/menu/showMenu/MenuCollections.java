package menu.showMenu;

import java.util.HashMap;
import java.util.Map;

public class MenuCollections {

    private static Map<String, ShowMenu> menuMap = new HashMap<>();

    static {
        menuMap.put("main", new ShowMainMenu());
        menuMap.put("add", new ShowAddBusMenu());
        menuMap.put("sort", new ShowSortingMenu());
        menuMap.put("result", new ShowResultMenu());
    }

    public static Map<String, ShowMenu> getMenuMap() {
        return menuMap;
    }
}