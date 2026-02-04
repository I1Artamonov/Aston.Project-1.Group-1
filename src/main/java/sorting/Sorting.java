package sorting;

import customCollections.CustomList;
import entity.Bus;

import java.util.Comparator;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 25-01-2026
 * Description: A class for sorting buses
 */
public class Sorting {
    /**
     * @ Method Name: selectSorting
     * @ Description: creation a comparator for sorting
     * @ param      : [int] [number] -> user-selected number of sorting
     * @ return     : java.util.Comparator<bus.Bus>
     */
    public static Comparator<Bus> selectComparator(int number) {
        Comparator<Bus> comparator;
        switch (number) {
            case 1 -> comparator = Comparator.naturalOrder();
            case 2 -> comparator = Comparator.comparing(Bus::getModel)
                    .thenComparing(Bus::getNumber).thenComparing(Bus::getMileage);
            case 3 -> comparator = Comparator.comparingInt(Bus::getMileage)
                    .thenComparing(Bus::getNumber).thenComparing(Bus::getModel);
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
    public static CustomList<Bus> sorts(CustomList<Bus> list, Comparator<Bus> comparator) {
        CustomList<Bus> result = new CustomList<>(list);
        for (int i = 0; i < result.size(); i++) {
            int minIndex = i;
            Bus minBus = result.get(i);
            for (int j = i + 1; j < result.size(); j++) {
                if (comparator.compare(result.get(j), minBus) < 0) {
                    minIndex = j;
                    minBus = result.get(j);
                }
            }
            result.set(minIndex, result.get(i));
            result.set(i, minBus);
        }
        return result;
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
    public static CustomList<Bus> sortEvenKeepOdd(CustomList<Bus> buses) {
        CustomList<Integer> evenIndices = new CustomList<>();
        CustomList<Bus> evenValues = new CustomList<>();
        for (int i = 0; i < buses.size(); i++) {
            int sortedField = buses.get(i).getNumber();
            if (sortedField % 2 == 0) {
                evenIndices.add(i);
                evenValues.add(buses.get(i));
            }
        }

        evenValues = sorts(evenValues, Comparator.naturalOrder());

        CustomList<Bus> result = new CustomList<>(buses);
        for (int i = 0; i < evenIndices.size(); i++) {
            int index = evenIndices.get(i);
            Bus sortedEvenValue = evenValues.get(i);
            result.set(index, sortedEvenValue);
        }
        return result;
    }
}
