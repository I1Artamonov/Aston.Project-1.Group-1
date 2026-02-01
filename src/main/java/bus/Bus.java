package bus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 24-01-2026
 * Description: A class which describes the entity of a bus
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Bus extends Car implements Comparable<Bus>, Generated<Bus> {
    private int number;

    protected Bus(BusBuilder builder) {
        super(builder.getModel(), builder.getMileage());
        this.number = builder.getNumber();
    }

    @Override
    public boolean checkBuilding() {
        return super.checkBuilding() && number > 0;
    }

    @Override
    public Bus generate() {
        return new BusBuilder()
                .setModel(Generated.generateFromList(busModels))
                .setMileage(Generated.generateNumber(1000, 0))
                .setNumber(Generated.generateNumber(100, 1))
                .build();
    }

    @Override
    public int compareTo(Bus bus) {
        if (this.getModel().compareTo(bus.getModel()) != 0) {
            return this.getModel().compareTo(bus.getModel());
        }
        if (this.getMileage() != bus.getMileage()) {
            return Integer.compare(this.getMileage(), bus.getMileage());
        }
        return Integer.compare(number, bus.getNumber());
    }

    @Override
    public String toString() {
        return String.format("model: %25s | mileage:%5d | number:%5d",
                getModel(), getMileage(), number);
    }
}
