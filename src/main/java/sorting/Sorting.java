package sorting;

import entity.Bus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 25-01-2026
 * Description: A class for sorting buses
 */
public class Sorting {
    public static String selectSorting() {
        return "Choose sorting method: " +
                "to sort by models press 1," +
                "to sort by mileage press 2," +
                "to sort by number press 3";
    }

    /**
     * @ Method Name: selectSorting
     * @ Description: creation a comparator for sorting
     * @ param      : [int] [number] -> user-selected number of sorting
     * @ return     : java.util.Comparator<bus.Bus>
     */
    public Comparator<Bus> selectComparator(int number) {
        Comparator<Bus> comparator;
        switch (number) {
            case 1 -> comparator = Comparator.comparing(Bus::getModel)
                    .thenComparing(Bus::getMileage).thenComparing(Bus::getNumber);
            case 2 -> comparator = Comparator.comparingInt(Bus::getMileage)
                    .thenComparing(Bus::getModel).thenComparing(Bus::getNumber);
            case 3 -> comparator = Comparator.comparingInt(Bus::getNumber)
                    .thenComparing(Bus::getModel).thenComparing(Bus::getMileage);
            default -> throw new IllegalArgumentException("Incorrect sorting choice");
        }
        return comparator;
    }

    /**
     * @ Method Name: sort
     * @ Description: Selection Sort
     * @ param      : [java.util.List<bus.Bus>, java.util.Comparator<bus.Bus>] [list, comparator] ->
     * the list of buses and the comparator for sort
     * @ return     : java.util.List<bus.Bus>
     */
    public List<Bus> selectionSort(List<Bus> list, Comparator<Bus> comparator) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            Bus minBus = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), minBus) < 0) {
                    minIndex = j;
                    minBus = list.get(j);
                }
            }
            list.set(minIndex, list.get(i));
            list.set(i, minBus);
        }
        return list;
    }

    /**
     * @ Method Name: sortEvenKeepOdd
     * @ Description: the additional task 1 - objects with even values of some numeric field
     * should be sorted in natural order, and objects with odd values should remain
     * in their original positions;
     * steps:
     * 1. collect indexes and even values
     * 2. sorting even values (selection sort)
     * 3. collect resulting list - set the sorted even values for the corresponding positions
     * @ param      : [java.util.List<bus.Bus>, int] [buses, selectedField] ->
     * the list of buses and the number of user-selected field
     * @ return     : java.util.List<bus.Bus>
     */
    public List<Bus> sortEvenKeepOdd(List<Bus> buses) {
        List<Integer> evenIndices = new ArrayList<>();
        List<Bus> evenValues = new ArrayList<>();
        for (int i = 0; i < buses.size(); i++) {
            int sortedField = buses.get(i).getNumber();
            if (sortedField % 2 == 0) {
                evenIndices.add(i);
                evenValues.add(buses.get(i));
            }
        }

        selectionSort(evenValues, Comparator.naturalOrder());

        List<Bus> result = new ArrayList<>(buses);
        for (int i = 0; i < evenIndices.size(); i++) {
            int index = evenIndices.get(i);
            Bus sortedEvenValue = evenValues.get(i);
            result.set(index, sortedEvenValue);
        }
        return result;
    }
}
