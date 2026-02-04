package sorting;

import customCollections.CustomList;
import entity.Bus;
import java.util.Comparator;

public class Sorting {

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
